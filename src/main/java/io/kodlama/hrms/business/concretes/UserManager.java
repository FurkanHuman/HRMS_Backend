package io.kodlama.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

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
    private static final String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {

        Result result = BusinessEngine.run(emailControl(user.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();

        userDao.save(user);
        return result;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    private Result emailControl(String email) {
        Pattern pattern = Pattern.compile(email_pattern, Pattern.CASE_INSENSITIVE);

        if (userDao.findbyEmail(email) && pattern.matcher(email).find())
            return new ErrorResult();
        return new SuccessResult();
    }
}
