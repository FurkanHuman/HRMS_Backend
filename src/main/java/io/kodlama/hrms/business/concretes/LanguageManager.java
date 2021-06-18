package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.LanguageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.LanguageDao;
import io.kodlama.hrms.entities.concretes.Language;
import io.kodlama.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;

    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
    }

    public List<Result> add(LanguageDto languageDto) {
        AllDataResult allDataResult = checkLanguage(languageDto);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        Language language = new Language();
        language.setName(languageDto.getLanguageName());
        this.languageDao.save(language);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkLanguage(LanguageDto languageDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (languageDto.getLanguageName().isBlank())
            allDataResult.addResult(new ErrorResult("boş geçilemez"));
        if (this.languageDao.findByName(languageDto.getLanguageName()) != null)
            allDataResult.addResult(new ErrorResult(" Bu dil zaten var"));
        return allDataResult;
    }

}
