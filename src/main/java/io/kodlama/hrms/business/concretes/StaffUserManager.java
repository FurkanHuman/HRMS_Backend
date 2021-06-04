package io.kodlama.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.StaffUserService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.StaffUserDao;
import io.kodlama.hrms.dataAccess.abstracts.UserDao;
import io.kodlama.hrms.entities.concretes.StaffUser;

@Service
public class StaffUserManager extends UserManager<StaffUser> implements StaffUserService {
    private final StaffUserDao staffUserDao;

    @Autowired
    public StaffUserManager(UserDao<StaffUser> userDao, StaffUserDao staffUserDao) {
        super(userDao);
        this.staffUserDao = staffUserDao;
    }

    @Override
    public Result add(StaffUser staffUser) {

        Result result = BusinessEngine.run(verify(staffUser), super.emailControl(staffUser.getEMail()));

        if (!result.isSuccess())
            return result;

        this.staffUserDao.save(staffUser);

        return new SuccessResult();
    }

    private Result verify(StaffUser staffUser) {

        if (!staffUser.isVerify())
            staffUser.setVerify(true);

        return new SuccessResult();
    }

    @Override
    public Result delete(StaffUser staffUser) {
        staffUserDao.delete(staffUser);
        return new SuccessResult();
    }

}
