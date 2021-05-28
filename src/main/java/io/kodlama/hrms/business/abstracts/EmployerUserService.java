package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.EmployerUser;

public interface EmployerUserService {
    Result register(EmployerUser employerUser);

    DataResult<List<EmployerUser>> getAll();
}