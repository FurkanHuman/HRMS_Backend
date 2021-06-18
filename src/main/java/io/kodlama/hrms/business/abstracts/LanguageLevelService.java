package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.LanguageLevel;
import io.kodlama.hrms.entities.dtos.LanguageLevelDto;

public interface LanguageLevelService {

    DataResult<List<LanguageLevel>> getAll();

    List<Result> add(LanguageLevelDto languageLevelDto);
}
