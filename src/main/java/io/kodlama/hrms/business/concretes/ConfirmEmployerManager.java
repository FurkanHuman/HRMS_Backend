package io.kodlama.hrms.business.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.ConfirmEmployerService;
import io.kodlama.hrms.core.adapters.abstracts.EmailSenderService;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import io.kodlama.hrms.entities.concretes.ConfirmEmployer;
import io.kodlama.hrms.entities.concretes.EmployerUser;
import io.kodlama.hrms.entities.concretes.StaffUser;
import net.bytebuddy.utility.RandomString;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService {

    private final ConfirmEmployerDao confirmEmployerDao;
    private final EmailSenderService emailSenderService;

    @Autowired
    public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao, EmailSenderService emailSenderService) {
        this.confirmEmployerDao = confirmEmployerDao;
        this.emailSenderService = emailSenderService;
    }

    public void generateCode(EmployerUser employerUser) {
        ConfirmEmployer confirmEmployer = new ConfirmEmployer();
        confirmEmployer.setConfirmed(false);
        confirmEmployer.setEmployerUser(employerUser);
        confirmEmployer.setCreatedDate(LocalDateTime.now());
        confirmEmployer.setVerifyCode(RandomString.make(32));
        emailSenderService.sendMail(confirmEmployer.getVerifyCode());
        confirmEmployerDao.save(confirmEmployer);

    }

    public Result verifyCodeConfirmEmployer(StaffUser staffUser, EmployerUser employerUser, String generatedString) {
        ConfirmEmployer confirmEmployer = confirmEmployerDao.existsByverifyCode(generatedString);

        if (confirmEmployer.getEmployerUser() != employerUser)
            return new ErrorResult();

        confirmEmployer.setConfirmedDate(LocalDateTime.now());
        confirmEmployer.setEmployerUser(employerUser);
        confirmEmployer.setStaffUser(staffUser);
        confirmEmployer.setConfirmed(true);
        confirmEmployerDao.save(confirmEmployer);
        return new SuccessResult();
    }

}