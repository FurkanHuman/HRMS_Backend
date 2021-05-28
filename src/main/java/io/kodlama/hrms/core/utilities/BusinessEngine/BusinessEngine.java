package io.kodlama.hrms.core.utilities.BusinessEngine;

import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessResult;

public class BusinessEngine {
    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess())
                return logic;
        }
        return new SuccessResult();
    }
}
