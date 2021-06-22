package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.LanguageLevelService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.LanguageLevelDao;
import io.kodlama.hrms.entities.concretes.LanguageLevel;
import io.kodlama.hrms.entities.dtos.LanguageLevelAddDto;

@Service
public class LanguageLevelManager implements LanguageLevelService {

    private final LanguageLevelDao languageLevelDao;

    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
        this.languageLevelDao = languageLevelDao;
    }

    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>(this.languageLevelDao.findAll());
    }

    public List<Result> add(LanguageLevelAddDto languageLevelDto) {

        AllDataResult allDataResult = checkLanguageLevel(languageLevelDto);
        if (!allDataResult.isSuccess())
            allDataResult.getErrorResults();

        LanguageLevel languageLevel = new LanguageLevel();
        languageLevel.setName(languageLevel.getName());
        languageLevel.setLevel(languageLevel.getLevel());

        this.languageLevelDao.save(languageLevel);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkLanguageLevel(LanguageLevelAddDto languageLevelDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (languageLevelDto.getLevel() == 0)
            allDataResult.addResult(new ErrorResult("boş level"));

        if (this.languageLevelDao.findByName(languageLevelDto.getName()))
            allDataResult.addResult(new ErrorResult("aynısı var"));

        if (languageLevelDto.getName().isBlank())
            allDataResult.addResult(new ErrorResult("boş geçilmez"));

        return allDataResult;
    }

}
