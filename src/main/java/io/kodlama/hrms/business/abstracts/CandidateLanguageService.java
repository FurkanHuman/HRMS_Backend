package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CandidateLanguage;
import io.kodlama.hrms.entities.dtos.LanguageAddDto;

public interface CandidateLanguageService {

    DataResult<List<CandidateLanguage>> getAll();

    List<Result> add(LanguageAddDto languageAddDto);
}
