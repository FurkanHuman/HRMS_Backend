package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateLanguageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateLanguageDao;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.LanguageDao;
import io.kodlama.hrms.dataAccess.abstracts.LanguageLevelDao;
import io.kodlama.hrms.entities.concretes.CandidateLanguage;
import io.kodlama.hrms.entities.dtos.LanguageAddDto;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private final CandidateLanguageDao candidateLanguageDao;
    private final CandidateUserDao candidateUserDao;
    private final LanguageLevelDao languageLevelDao;
    private final LanguageDao languageDao;

    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao, CandidateUserDao candidateUserDao,
            LanguageLevelDao languageLevelDao, LanguageDao languageDao) {
        this.candidateLanguageDao = candidateLanguageDao;
        this.candidateUserDao = candidateUserDao;
        this.languageLevelDao = languageLevelDao;
        this.languageDao = languageDao;
    }

    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll());
    }

    @Override
    public List<Result> add(LanguageAddDto languageAddDto) {
        AllDataResult allDataResult = checkLanguageAddDto(languageAddDto);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        CandidateLanguage candidateLanguage = new CandidateLanguage();

        candidateLanguage.setCandidate(this.candidateUserDao.findById(languageAddDto.getCandidateId()).get());
        candidateLanguage.setDescription(languageAddDto.getDescription());
        candidateLanguage.setLanguage(this.languageDao.findById(languageAddDto.getLanguageId()).get());
        candidateLanguage.setLanguageLevel(this.languageLevelDao.findById(languageAddDto.getLanguageLevelId()).get());

        allDataResult.addResult(new SuccessResult("kayıt başarılı"));
        candidateLanguageDao.save(candidateLanguage);

        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkLanguageAddDto(LanguageAddDto languageAddDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (this.candidateUserDao.findById(languageAddDto.getCandidateId()).isEmpty())
            allDataResult.addResult(new ErrorResult("candidate id bulunamadı"));

        if (this.candidateLanguageDao.findById(languageAddDto.getLanguageLevelId()).isEmpty())
            allDataResult.addResult(new ErrorResult("candidate language id bulunamadı"));

        return null;
    }
}
