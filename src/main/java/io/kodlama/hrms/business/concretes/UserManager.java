package io.kodlama.hrms.business.concretes;

import java.util.List;

import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.UserDao;
import io.kodlama.hrms.entities.concretes.User;

public class UserManager implements UserService {

    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result register(User user) {

        Result result = BusinessEngine.run(emailControl(user.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();

        userDao.save(user);
        return result;
    }

    private Result emailControl(String email) {
        if (userDao.findbyEmail(email))
            return new ErrorResult();
        return new SuccessResult();
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }
}
