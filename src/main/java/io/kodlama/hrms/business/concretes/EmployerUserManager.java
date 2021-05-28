package io.kodlama.hrms.business.concretes;

import java.util.List;

import io.kodlama.hrms.business.abstracts.EmployerUserService;
import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.EmployerUserDao;
import io.kodlama.hrms.entities.concretes.EmployerUser;

public class EmployerUserManager implements EmployerUserService {

    private EmployerUserDao employerUserDao;
    private UserService userService;

    public EmployerUserManager(EmployerUserDao employerUserDao, UserService userService) {
        this.employerUserDao = employerUserDao;
        this.userService = userService;
    }

    @Override
    public Result register(EmployerUser employerUser) {

        Result result = BusinessEngine.run(employerValidator(employerUser));
        if (!result.isSuccess())
            return new ErrorResult();

        employerUserDao.save(employerUser);
        userService.add(employerUser);
        return new SuccessResult();
    }

    private Result employerValidator(EmployerUser employerUser) {
        return null;
    }

    @Override
    public DataResult<List<EmployerUser>> getAll() {
        return new SuccessDataResult<List<EmployerUser>>(employerUserDao.findAll());
    }

}