package io.kodlama.hrms.business.concretes;

import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.ConfirmEmployerService;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import io.kodlama.hrms.dataAccess.abstracts.EmployerUserDao;
import io.kodlama.hrms.entities.concretes.ConfirmEmployer;
import io.kodlama.hrms.entities.concretes.EmployerUser;
import io.kodlama.hrms.entities.concretes.StaffUser;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService {
    private final ConfirmEmployerDao confirmEmployerDao;
    // private EmployerUserDao employerUserDao;

    public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao, EmployerUserDao employerUserDao) {
        this.confirmEmployerDao = confirmEmployerDao;
        // this.employerUserDao = employerUserDao;
    }

    @Override
    public Result createConfirmEmployer(EmployerUser employerUser) {
        StaffUser staffUser = new StaffUser();
        ConfirmEmployer cEmployer = new ConfirmEmployer();
        cEmployer.setEmployerId(employerUser);
        cEmployer.setConfirmedStaffUser(staffUser);

        this.confirmEmployerDao.save(cEmployer);

        return new SuccessResult();
    }

    @Override
    public Result confirmUser(EmployerUser employerUser) {

        // if (!employerUserDao.existsByCompanyName(employerUser.getCompanyName()))
        // return new ErrorResult();

        // if(employerUserDao.getByCompanyName(employerUser.getCompanyName())
        // return new ErrorResult();
        return new ErrorResult("Çalışmayan Metot");
    }
}
