package io.kodlama.hrms.business.abstracts;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.StaffUser;

public interface StaffUserService<T extends StaffUser> {
    Result add(T staffUser);

    Result delete(T staffUser);

    Result update(T staffUser);

}
