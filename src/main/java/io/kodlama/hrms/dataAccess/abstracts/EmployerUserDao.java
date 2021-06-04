package io.kodlama.hrms.dataAccess.abstracts;

import io.kodlama.hrms.entities.concretes.EmployerUser;

public interface EmployerUserDao extends UserDao<EmployerUser> {

    boolean existsByCompanyName(String companyName);

    EmployerUser getByCompanyName(String companyName);

}
