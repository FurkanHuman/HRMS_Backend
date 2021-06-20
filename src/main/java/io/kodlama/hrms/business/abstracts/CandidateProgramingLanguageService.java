package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CandidateProgramingLanguage;
import io.kodlama.hrms.entities.dtos.CandidateProgramingAddDto;
import io.kodlama.hrms.entities.dtos.CandidateProgramingGetDto;

public interface CandidateProgramingLanguageService {
    DataResult<List<CandidateProgramingLanguage>> getAll();

    DataResult<List<CandidateProgramingGetDto>> getByCandidate(int candidateId);

    List<Result> add(CandidateProgramingAddDto addDto);
}
