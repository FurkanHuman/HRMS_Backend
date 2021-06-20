package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateProgramingLanguageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateProgramingLanguageDao;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.ProgramingLanguageDao;
import io.kodlama.hrms.entities.concretes.CandidateProgramingLanguage;
import io.kodlama.hrms.entities.dtos.CandidateProgramingAddDto;
import io.kodlama.hrms.entities.dtos.CandidateProgramingGetDto;

@Service
public class CandidateProgramingLanguageManager implements CandidateProgramingLanguageService {

    private final CandidateProgramingLanguageDao candidateProgramingLanguageDao;
    private final CandidateUserDao candidateUserDao;
    private final ProgramingLanguageDao programingLanguageDao;

    @Autowired
    public CandidateProgramingLanguageManager(CandidateProgramingLanguageDao candidateProgramingLanguageDao,
            CandidateUserDao candidateUserDao, ProgramingLanguageDao programingLanguageDao) {
        this.candidateProgramingLanguageDao = candidateProgramingLanguageDao;
        this.candidateUserDao = candidateUserDao;
        this.programingLanguageDao = programingLanguageDao;
    }

    public List<Result> add(CandidateProgramingAddDto addDto) {
        AllDataResult allDataResult = checkAdd(addDto);

        if (!allDataResult.isSuccess())
            allDataResult.getErrorResults();

        CandidateProgramingLanguage programingLanguage = new CandidateProgramingLanguage();
        programingLanguage.setCandidate(this.candidateUserDao.findById(addDto.getCandidateId()).get());
        programingLanguage
                .setProgramingLanguage(this.programingLanguageDao.findById(addDto.getProgramingLanguageId()).get());
        programingLanguage.setComment(addDto.getComment());
        allDataResult.addResult(new SuccessResult("kayıt başaırılı"));
        this.candidateProgramingLanguageDao.save(programingLanguage);

        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkAdd(CandidateProgramingAddDto addDto) {
        AllDataResult allDataResult = new AllDataResult();
        if (this.candidateUserDao.findById(addDto.getCandidateId()).isEmpty())
            allDataResult.addResult(new ErrorResult("candidate id bulunamadı"));
        if (this.programingLanguageDao.findById(addDto.getProgramingLanguageId()).isEmpty())
            allDataResult.addResult(new ErrorResult("language id bulunamadı"));

        return allDataResult;
    }

    public DataResult<List<CandidateProgramingLanguage>> getAll() {
        return new SuccessDataResult<List<CandidateProgramingLanguage>>(this.candidateProgramingLanguageDao.findAll());
    }

    @Override
    public DataResult<List<CandidateProgramingGetDto>> getByCandidate(int candidateId) {
        return new SuccessDataResult<List<CandidateProgramingGetDto>>(
                this.candidateProgramingLanguageDao.getByCandidate(candidateId));
    }

}
