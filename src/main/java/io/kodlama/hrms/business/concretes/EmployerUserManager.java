package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.EmployerUserService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.EmployerUserDao;
import io.kodlama.hrms.dataAccess.abstracts.UserDao;
import io.kodlama.hrms.entities.concretes.EmployerUser;

@Service
public class EmployerUserManager extends UserManager<EmployerUser> implements EmployerUserService {

    private EmployerUserDao employerUserDao;

    @Autowired
    public EmployerUserManager(UserDao<EmployerUser> userDao, EmployerUserDao employerUserDao) {
        super(userDao);
        this.employerUserDao = employerUserDao;
    }

    @Override
    public Result register(EmployerUser employerUser) {

        Result result = BusinessEngine.run(validateEmail(employerUser), ValidateEmployer(employerUser),
                super.emailControl(employerUser.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();

        employerUserDao.save(employerUser);
        return new SuccessResult();
    }

    private Result validateEmail(EmployerUser employerUser) {
        String email = employerUser.getDomainMail();
        String webAddress = employerUser.getWeb_Address();

        String domain = webAddress.split("www.")[1];

        if (domain.equals(email.split("@")[1]))
            return new SuccessResult();
        return new ErrorResult();
    }

    private Result ValidateEmployer(EmployerUser employerUser) {

        if (!employerUser.getEMail().isEmpty())// system personel onayı eklenecek
            return new SuccessResult();

        return new ErrorResult();
    }
}