package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.EmployerUser;

public interface EmployerUserService extends UserService<EmployerUser> {
    Result register(EmployerUser employerUser);
}