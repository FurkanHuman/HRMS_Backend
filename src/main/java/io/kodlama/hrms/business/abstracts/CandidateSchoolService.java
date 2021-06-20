package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CandidateSchool;
import io.kodlama.hrms.entities.dtos.CandidateSchoolAddDto;

public interface CandidateSchoolService {
    DataResult<List<CandidateSchool>> getAll();

    List<Result> addCandidateScholl(CandidateSchoolAddDto candidateSchoolAddDto);

}
