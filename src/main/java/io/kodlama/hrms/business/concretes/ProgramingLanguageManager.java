package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.ProgramingLanguageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.ProgramingLanguageDao;
import io.kodlama.hrms.entities.concretes.ProgramingLanguage;
import io.kodlama.hrms.entities.dtos.ProgramingLanguageDto;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {

    private final ProgramingLanguageDao programingLanguageDao;

    @Autowired
    public ProgramingLanguageManager(ProgramingLanguageDao programingLanguageDao) {
        this.programingLanguageDao = programingLanguageDao;
    }

    public DataResult<List<ProgramingLanguage>> getAll() {
        return new SuccessDataResult<List<ProgramingLanguage>>(this.programingLanguageDao.findAll());
    }

    public List<Result> add(ProgramingLanguageDto programingLanguageDto) {
        AllDataResult allDataResult = checkProgramingLanguage(programingLanguageDto);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setName(programingLanguageDto.getProgramingName());
        this.programingLanguageDao.save(programingLanguage);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkProgramingLanguage(ProgramingLanguageDto programingLanguageDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (programingLanguageDto.getProgramingName().isBlank())
            allDataResult.addResult(new ErrorResult("boş geçilmez"));
        if (this.programingLanguageDao.getByName(programingLanguageDto.getProgramingName()) != null)
            allDataResult.addResult(new ErrorResult("kayıt var"));
        return allDataResult;
    }
}
