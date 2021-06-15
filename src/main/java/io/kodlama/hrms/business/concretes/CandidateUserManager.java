package io.kodlama.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateUserService;
import io.kodlama.hrms.business.abstracts.VerifyService;
import io.kodlama.hrms.core.adapters.abstracts.RealCheckService;
import io.kodlama.hrms.core.adapters.models.mernisPerson;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateLanguageDao;
import io.kodlama.hrms.dataAccess.abstracts.CandidateSchoolDao;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.PhotoDao;
import io.kodlama.hrms.dataAccess.abstracts.UserDao;
import io.kodlama.hrms.dataAccess.abstracts.JobExperienceDao;
import io.kodlama.hrms.entities.concretes.CandidateLanguage;
import io.kodlama.hrms.entities.concretes.CandidateSchool;
import io.kodlama.hrms.entities.concretes.CandidateUser;
import io.kodlama.hrms.entities.concretes.JobExperience;
import io.kodlama.hrms.entities.concretes.Language;
import io.kodlama.hrms.entities.concretes.Photo;
import io.kodlama.hrms.entities.dtos.CandidateCvDto;
import io.kodlama.hrms.entities.dtos.CvGetDto;
import io.kodlama.hrms.entities.dtos.JobExperienceCvDto;
import io.kodlama.hrms.entities.dtos.LanguageCvDto;
import io.kodlama.hrms.entities.dtos.SchoolCvDto;

@Service
public class CandidateUserManager extends UserManager<CandidateUser> implements CandidateUserService {

    private final CandidateUserDao candidateUserDao;
    private final RealCheckService realCheckService;
    private final CandidateLanguageDao candidateLanguageDao;
    private final CandidateSchoolDao candidateSchoolDao;
    private final PhotoDao photoDao;
    private final JobExperienceDao jobExperienceDao;
    private final VerifyService verifyService;

    @Autowired
    public CandidateUserManager(UserDao<CandidateUser> userDao, CandidateUserDao candidateUserDao,
            RealCheckService realCheckService, CandidateLanguageDao candidateLanguageDao,
            CandidateSchoolDao candidateSchoolDao, PhotoDao photoDao, JobExperienceDao jobExperienceDao,
            VerifyService verifyService) {
        super(userDao);
        this.candidateUserDao = candidateUserDao;
        this.realCheckService = realCheckService;
        this.candidateLanguageDao = candidateLanguageDao;
        this.candidateSchoolDao = candidateSchoolDao;
        this.photoDao = photoDao;
        this.jobExperienceDao = jobExperienceDao;
        this.verifyService = verifyService;
    }

    private int namelength = 3;

    @Override
    public Result register(CandidateUser candidateUser) {
        Result result = BusinessEngine.run(candidateUserCheck(candidateUser), nationalityIdCheck(candidateUser),
                super.emailControl(candidateUser.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();

        verifyService.generateCode(candidateUser);
        candidateUserDao.save(candidateUser);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateUser>> getAll() {
        return new SuccessDataResult<List<CandidateUser>>(candidateUserDao.findAll());
    }

    private Result candidateUserCheck(CandidateUser candidateUser) {
        if (candidateUser.getName().length() >= namelength && candidateUser.getSurName().length() >= namelength)
            return new SuccessResult();
        return new ErrorResult();
    }

    private Result nationalityIdCheck(CandidateUser candidateUser) {
        mernisPerson mernisPerson = new mernisPerson(candidateUser.getName(), candidateUser.getSurName(),
                candidateUser.getNationalIdentity(), candidateUser.getBirthDate());
        boolean result = realCheckService.validate(mernisPerson);
        if (!result)
            return new ErrorResult();
        candidateUser.setVerify(true);
        return new SuccessResult();
    }

    @Override
    public DataResult<CvGetDto> getCv(int candidateId) {

        CandidateUser candidateUser = new CandidateUser();
        candidateUser = this.candidateUserDao.findById(candidateId).get();

        CandidateCvDto candidateCvDto = new CandidateCvDto();
        candidateCvDto.setId(candidateUser.getId());
        candidateCvDto.setBirthDate(candidateUser.getBirthDate());
        candidateCvDto.setName(candidateUser.getName());
        candidateCvDto.setSurName(candidateUser.getSurName());

        List<CandidateLanguage> languages = this.candidateLanguageDao.findByCandidateId(candidateId);

        CvGetDto cvGetDto = new CvGetDto();
        List<LanguageCvDto> languageCvDtos = new ArrayList<LanguageCvDto>();
        LanguageCvDto languageCvDto;

        for (CandidateLanguage language : languages) {// foreach
            languageCvDto = new LanguageCvDto();
            languageCvDto.setDescription(language.getDescription());
            languageCvDto.setId(language.getId());
            languageCvDto.setLanguage(language.getLanguage().getName());
            languageCvDto.setLevelName(language.getLanguageLevel().getName());
            languageCvDto.setLevel(language.getLanguageLevel().getLevel());
            languageCvDtos.add(languageCvDto);
        }

        List<CandidateSchool> candidateSchools = this.candidateSchoolDao.findByCandidateId(candidateId);

        List<SchoolCvDto> schoolCvDtos = new ArrayList<SchoolCvDto>();
        SchoolCvDto schoolCvDto;

        for (CandidateSchool school : candidateSchools) {

            schoolCvDto = new SchoolCvDto();
            schoolCvDto.setAvatar(school.getSchool().getAvatar());
            schoolCvDto.setDescription(school.getDescription());
            schoolCvDto.setGraduation(school.getGraduation());
            schoolCvDto.setSchoolName(school.getSchool().getName());
            schoolCvDto.setSchoolType(school.getSchool().getSchoolType().getName());
            schoolCvDto.setWebSite(school.getSchool().getWebSite());
            schoolCvDtos.add(schoolCvDto);
        }

        List<Photo> photos = this.photoDao.findByUserId(candidateId);
        List<JobExperience> experiences = this.jobExperienceDao
                .findByCandidate(this.candidateUserDao.findById(candidateId).get());

        List<JobExperienceCvDto> experienceCvDtos = new ArrayList<JobExperienceCvDto>();

        JobExperienceCvDto experienceCvDto;

        for (JobExperience jobExperience : experiences) {
            experienceCvDto = new JobExperienceCvDto();

            experienceCvDto.setCompanyName(jobExperience.getEmployer().getCompanyName());
            experienceCvDto.setCompanyPhone(jobExperience.getEmployer().getCompanyPhone());
            experienceCvDto.setDomainMail(jobExperience.getEmployer().getDomainMail());
            experienceCvDto.setExpEndDate(jobExperience.getExpEndDate());
            experienceCvDto.setExpStartDate(jobExperience.getExpStartDate());
            experienceCvDto.setId(jobExperience.getId());
            experienceCvDto.setPosition(jobExperience.getJobPosition().getPosition());
            experienceCvDto.setState(jobExperience.isState());
            experienceCvDto.setPositionId(jobExperience.getJobPosition().getId());
            experienceCvDto.setWeb_Address(jobExperience.getEmployer().getWeb_Address());
            experienceCvDtos.add(experienceCvDto);

        }

        cvGetDto.setJobExperiences(experienceCvDtos);
        cvGetDto.setPhotos(photos);
        cvGetDto.setSchools(schoolCvDtos);
        cvGetDto.setLanguages(languageCvDtos);
        cvGetDto.setCandidate(candidateCvDto);
        return new SuccessDataResult<CvGetDto>(cvGetDto);
    }
}