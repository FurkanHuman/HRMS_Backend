package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.JobExperienceService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.EmployerUserDao;
import io.kodlama.hrms.dataAccess.abstracts.JobExperienceDao;
import io.kodlama.hrms.dataAccess.abstracts.JobPositionDao;
import io.kodlama.hrms.entities.concretes.JobExperience;
import io.kodlama.hrms.entities.dtos.JobExperienceAddDto;

@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;
    private final CandidateUserDao candidateUserDao;
    private final EmployerUserDao employerUserDao;
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, CandidateUserDao candidateUserDao,
            EmployerUserDao employerUserDao, JobPositionDao jobPositionDao) {
        this.jobExperienceDao = jobExperienceDao;
        this.candidateUserDao = candidateUserDao;
        this.employerUserDao = employerUserDao;
        this.jobPositionDao = jobPositionDao;
    }

    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
    }

    @Override
    public List<Result> add(JobExperienceAddDto jobExperienceAddDto) {
        AllDataResult allDataResult = checkJobExperienceAddDto(jobExperienceAddDto);

        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        JobExperience experience = new JobExperience();

        experience.setCandidate(this.candidateUserDao.getById(jobExperienceAddDto.getCandidateId()));
        experience.setEmployer(this.employerUserDao.getById(jobExperienceAddDto.getEmployerId()));
        experience.setJobPosition(this.jobPositionDao.getById(jobExperienceAddDto.getJobPositionId()));
        experience.setState(jobExperienceAddDto.isState());
        experience.setExpStartDate(jobExperienceAddDto.getExpStartDate());
        experience.setExpEndDate(jobExperienceAddDto.getExpEndDate());

        allDataResult.addResult(new SuccessResult("işlem başarılı"));
        this.jobExperienceDao.save(experience);

        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkJobExperienceAddDto(JobExperienceAddDto jobExperienceAddDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (this.candidateUserDao.findById(jobExperienceAddDto.getCandidateId()).isEmpty())
            allDataResult.addResult(new ErrorResult("candidate id bulunamadı"));
        if (this.employerUserDao.findById(jobExperienceAddDto.getEmployerId()).isEmpty())
            allDataResult.addResult(new ErrorResult("employer user bulunamadı"));
        if (this.jobPositionDao.findById(jobExperienceAddDto.getJobPositionId()).isEmpty())
            allDataResult.addResult(new ErrorResult("job position id bulunamadı"));

        return allDataResult;
    }

}
