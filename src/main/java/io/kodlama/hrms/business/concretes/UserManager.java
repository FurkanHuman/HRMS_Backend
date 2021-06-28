package io.kodlama.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.UserDao;
import io.kodlama.hrms.entities.concretes.User;

@Service
public class UserManager<T extends User> implements UserService<T> {

    private final UserDao<T> userDao;
    private static final String email_pattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    @Autowired
    public UserManager(UserDao<T> userDao) {
        this.userDao = userDao;
    }

    public Result add(T user) {

        Result result = BusinessEngine.run(emailControl(user.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();

        userDao.save(user);
        return new SuccessResult();
    }

    public DataResult<List<T>> getAll() {
        return new SuccessDataResult<List<T>>(userDao.findAll());
    }

    public DataResult<T> getById(int id) {
        return new SuccessDataResult<T>(this.userDao.getById(id));
    }

    public Result emailControl(String email) {
        Pattern pattern = Pattern.compile(email_pattern, Pattern.CASE_INSENSITIVE);

        if (!pattern.matcher(email).find() || userDao.existsByeMail(email))
            return new ErrorResult();
        return new SuccessResult();
    }
}
