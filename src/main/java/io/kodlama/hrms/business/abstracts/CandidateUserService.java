package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.CandidateUser;

public interface CandidateUserService {
    Result add(CandidateUser candidateUser);

    Result delete(CandidateUser candidateUser);

    Result update(CandidateUser candidateUser);

    DataResult<List<CandidateUser>> getAll();
}
