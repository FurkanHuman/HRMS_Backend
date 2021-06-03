package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CandidateUser;

public interface CandidateUserService extends UserService<CandidateUser> {
    Result register(CandidateUser candidateUser);

    DataResult<List<CandidateUser>> getAll();
}
