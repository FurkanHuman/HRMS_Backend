package io.kodlama.hrms.business.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.VerifyService;
import io.kodlama.hrms.core.adapters.abstracts.EmailSenderService;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.VerifyDao;
import io.kodlama.hrms.entities.concretes.User;
import io.kodlama.hrms.entities.concretes.Verify;
import net.bytebuddy.utility.RandomString;

@Service
public class VerifyManager implements VerifyService {

    private final VerifyDao verifyDao;
    private final EmailSenderService emailSenderService;

    @Autowired
    public VerifyManager(VerifyDao verifyDao, EmailSenderService emailSenderService) {
        this.verifyDao = verifyDao;
        this.emailSenderService = emailSenderService;
    }

    public void generateCode(User User, int length) {
        Verify verify = new Verify();

        verify.setUser(User);
        verify.setCreatedDate(LocalDateTime.now());
        verify.setConfirmed(false);
        String generatedString = RandomString.make(length);

        verify.setVerifyCode(generatedString);
        verifyDao.save(verify);
        emailSenderService.sendMail(generatedString);
    }

    public Result verifyCode(User user, String generatedString) {

        Verify verify = verifyDao.existsByverifyCode(generatedString);

        return verify(user, verify);
    }

    private Result verify(User user, Verify verify) {
        if (verify.getUser() != user)
            return new ErrorResult("Doğrulama başarısız");
        verify.setConfirmedDate(LocalDateTime.now());
        verify.setConfirmed(true);
        return new SuccessResult("Doğrulama başarılı");
    }
}
