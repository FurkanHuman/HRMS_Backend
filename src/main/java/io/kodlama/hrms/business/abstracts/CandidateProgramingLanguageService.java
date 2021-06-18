package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CandidateProgramingLanguage;

public interface CandidateProgramingLanguageService {
    List<Result> add(CandidateProgramingLanguage candidateProgramingLanguage);

    DataResult<List<CandidateProgramingLanguage>> getAll();
}
