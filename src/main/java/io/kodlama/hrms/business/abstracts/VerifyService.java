package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;

import io.kodlama.hrms.entities.concretes.User;

public interface VerifyService {

    void generateCode(User User, int length);

    Result verifyCode(User user, String generatedString);
}
