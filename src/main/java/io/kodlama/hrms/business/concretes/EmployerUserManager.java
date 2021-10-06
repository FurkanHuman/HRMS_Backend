package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.ConfirmEmployerService;
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

    private final EmployerUserDao employerUserDao;
    private final ConfirmEmployerService confirmEmployerService;
    private final int gClength = 32;

    @Autowired
    public EmployerUserManager(UserDao<EmployerUser> userDao, EmployerUserDao employerUserDao,
            ConfirmEmployerService confirmEmployerService) {
        super(userDao);
        this.employerUserDao = employerUserDao;
        this.confirmEmployerService = confirmEmployerService;
    }

    public Result register(EmployerUser employerUser) {

        Result result = BusinessEngine.run(validateEmail(employerUser), ValidateEmployer(employerUser),
                super.emailControl(employerUser.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();
        employerUserDao.save(employerUser);
        confirmEmployerService.generateCode(employerUser, gClength);
        return new SuccessResult();
    }

    private Result validateEmail(EmployerUser employerUser) {
        String email = employerUser.getDomainMail();
        String webAddress = employerUser.getWeb_Address();

        if (webAddress.split("www.").length < 2)
            return new ErrorResult("www. eklenmelidir");

        if (email.split("@").length < 2)
            return new ErrorResult("email formatı hatalı");

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