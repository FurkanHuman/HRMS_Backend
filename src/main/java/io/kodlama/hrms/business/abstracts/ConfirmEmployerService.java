package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.EmployerUser;

public interface ConfirmEmployerService {
    Result createConfirmEmployer(EmployerUser employerUser);

    Result confirmUser(EmployerUser employerUser);
}
