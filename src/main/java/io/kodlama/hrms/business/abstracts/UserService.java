package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.User;

public interface UserService<T extends User> {

    Result add(T user);

    DataResult<List<T>> getAll();
}