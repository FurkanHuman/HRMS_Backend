package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateLanguageService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateLanguageDao;
import io.kodlama.hrms.entities.concretes.CandidateLanguage;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private final CandidateLanguageDao candidateLanguageDao;

    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        this.candidateLanguageDao = candidateLanguageDao;
    }

    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll());
    }

}
