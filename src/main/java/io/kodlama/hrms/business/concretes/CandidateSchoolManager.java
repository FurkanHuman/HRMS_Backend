package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateSchoolService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateSchoolDao;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.SchoolDao;
import io.kodlama.hrms.entities.concretes.CandidateSchool;
import io.kodlama.hrms.entities.dtos.CandidateSchoolAddDto;

@Service
public class CandidateSchoolManager implements CandidateSchoolService {
    private final CandidateSchoolDao candidateSchoolDao;
    private final CandidateUserDao candidateUserDao;
    private final SchoolDao schoolDao;

    @Autowired
    public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao, CandidateUserDao candidateUserDao,
            SchoolDao schoolDao) {
        this.candidateSchoolDao = candidateSchoolDao;
        this.candidateUserDao = candidateUserDao;
        this.schoolDao = schoolDao;
    }

    public DataResult<List<CandidateSchool>> getAll() {

        return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAll());
    }

    public List<Result> addCandidateScholl(CandidateSchoolAddDto candidateSchoolAddDto) {

        AllDataResult allDataResult = checkCandidateSchool(candidateSchoolAddDto);

        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        CandidateSchool candidateSchool = new CandidateSchool();
        candidateSchool.setCandidate(this.candidateUserDao.findById(candidateSchoolAddDto.getCandidateId()).get());
        candidateSchool.setSchool(this.schoolDao.findById(candidateSchoolAddDto.getSchoolId()).get());
        candidateSchool.setGraduation(candidateSchoolAddDto.getGraduation());
        candidateSchool.setDescription(candidateSchoolAddDto.getDescription());
        allDataResult.addResult(new SuccessResult("işlem Başarılı"));
        candidateSchoolDao.save(candidateSchool);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkCandidateSchool(CandidateSchoolAddDto candidateSchoolAddDto) {
        AllDataResult allDataResult = new AllDataResult();
        if (this.candidateUserDao.findById(candidateSchoolAddDto.getCandidateId()).isEmpty())
            allDataResult.addResult(new ErrorResult("candidate id bulunamadı"));
        if (this.schoolDao.findById(candidateSchoolAddDto.getSchoolId()).isEmpty())
            allDataResult.addResult(new ErrorResult("school id bulunamadı"));
        return allDataResult;
    }

}
