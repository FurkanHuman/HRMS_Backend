package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.StaffUser;

public interface StaffUserService extends UserService<StaffUser> {
    Result add(StaffUser staffUser);

    Result delete(StaffUser staffUser);

    DataResult<List<StaffUser>> getAll();
}
