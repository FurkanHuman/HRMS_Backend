package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.EmployerUser;

public interface EmployerUserService {
    Result add(EmployerUser employerUser);

    Result delete(EmployerUser employerUser);

    Result update(EmployerUser employerUser);

    DataResult<List<EmployerUser>> getAll();
}
