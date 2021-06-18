package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Language;
import io.kodlama.hrms.entities.dtos.LanguageDto;

public interface LanguageService {

    DataResult<List<Language>> getAll();

    List<Result> add(LanguageDto languageDto);

}
