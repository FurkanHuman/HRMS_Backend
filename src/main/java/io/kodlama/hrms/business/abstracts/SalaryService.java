package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Salary;

public interface SalaryService {

    Result add(Salary salary);

    DataResult<List<Salary>> getAll();

}
