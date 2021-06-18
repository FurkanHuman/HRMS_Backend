package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateProgramingLanguageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateProgramingLanguageDao;
import io.kodlama.hrms.entities.concretes.CandidateProgramingLanguage;

@Service
public class CandidateProgramingLanguageManager implements CandidateProgramingLanguageService {

    private final CandidateProgramingLanguageDao candidateProgramingLanguageDao;

    @Autowired
    public CandidateProgramingLanguageManager(CandidateProgramingLanguageDao candidateProgramingLanguageDao) {
        this.candidateProgramingLanguageDao = candidateProgramingLanguageDao;
    }

    public List<Result> add(CandidateProgramingLanguage candidateProgramingLanguage) {
        AllDataResult allDataResult = checkProgramingLanguage(candidateProgramingLanguage);

        if (!allDataResult.isSuccess())
            allDataResult.getErrorResults();

        CandidateProgramingLanguage programingLanguage = new CandidateProgramingLanguage();
        programingLanguage.setComment(candidateProgramingLanguage.getComment());
        this.candidateProgramingLanguageDao.save(programingLanguage);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkProgramingLanguage(CandidateProgramingLanguage candidateProgramingLanguage) {
        return null;
    }

    public DataResult<List<CandidateProgramingLanguage>> getAll() {
        return new SuccessDataResult<List<CandidateProgramingLanguage>>(this.candidateProgramingLanguageDao.findAll());
    }

}
