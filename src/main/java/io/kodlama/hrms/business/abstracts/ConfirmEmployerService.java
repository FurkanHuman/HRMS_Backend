package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.EmployerUser;
import io.kodlama.hrms.entities.concretes.StaffUser;

public interface ConfirmEmployerService {
    void generateCode(EmployerUser employerUser);

    Result verifyCodeConfirmEmployer(StaffUser staffUser, EmployerUser employerUser, String generatedString);
}
