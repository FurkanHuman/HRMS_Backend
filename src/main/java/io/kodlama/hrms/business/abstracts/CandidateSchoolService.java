package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolService {
    DataResult<List<CandidateSchool>> getAll();

}
