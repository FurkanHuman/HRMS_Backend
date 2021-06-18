package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.SalaryService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.SalaryDao;
import io.kodlama.hrms.entities.concretes.Salary;

@Service
public class SalaryManager implements SalaryService {
    private final SalaryDao salaryDao;

    @Autowired
    public SalaryManager(SalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }

    public Result add(Salary salary) {
        Result result = BusinessEngine.run(existsSalary(salary));
        if (!result.isSuccess())
            return new ErrorResult();
        salaryDao.save(salary);
        return new SuccessResult();

    }

    public DataResult<List<Salary>> getAll() {
        return new SuccessDataResult<List<Salary>>(this.salaryDao.findAll());
    }

    private Result existsSalary(Salary salary) {
        if (salaryDao.existsByscale(salary.getScale()))
            return new ErrorResult();
        return new SuccessResult();
    }
}
