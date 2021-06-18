package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.ProgramingLanguage;
import io.kodlama.hrms.entities.dtos.ProgramingLanguageDto;

public interface ProgramingLanguageService {

    DataResult<List<ProgramingLanguage>> getAll();

    List<Result> add(ProgramingLanguageDto programingLanguageDto);
}
