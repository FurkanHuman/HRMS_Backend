package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateUserService;
import io.kodlama.hrms.core.adapters.abstracts.RealCheckService;
import io.kodlama.hrms.core.adapters.models.mernisPerson;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.UserDao;
import io.kodlama.hrms.entities.concretes.CandidateUser;

@Service
public class CandidateUserManager extends UserManager<CandidateUser> implements CandidateUserService {

    private CandidateUserDao candidateUserDao;
    private RealCheckService realCheckService;

    @Autowired
    public CandidateUserManager(UserDao<CandidateUser> userDao, CandidateUserDao candidateUserDao,
            RealCheckService realCheckService) {
        super(userDao);
        this.candidateUserDao = candidateUserDao;
        this.realCheckService = realCheckService;
    }

    private int namelength = 3;

    @Override
    public Result register(CandidateUser candidateUser) {
        Result result = BusinessEngine.run(candidateUserCheck(candidateUser), nationalityIdCheck(candidateUser),
                super.emailControl(candidateUser.getEMail()));
        if (!result.isSuccess())
            return new ErrorResult();
        candidateUserDao.save(candidateUser);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CandidateUser>> getAll() {
        return new SuccessDataResult<List<CandidateUser>>(candidateUserDao.findAll());
    }

    private Result candidateUserCheck(CandidateUser candidateUser) {
        if (candidateUser.getName().length() >= namelength && candidateUser.getSurName().length() >= namelength)
            return new SuccessResult();
        return new ErrorResult();
    }

    private Result nationalityIdCheck(CandidateUser candidateUser) {
        mernisPerson mernisPerson = new mernisPerson(candidateUser.getName(), candidateUser.getSurName(),
                candidateUser.getNationalIdentity(), candidateUser.getBirthDate());
        boolean result = realCheckService.validate(mernisPerson);
        if (!result)
            return new ErrorResult();
        candidateUser.setVerify(true);
        return new SuccessResult();
    }
}