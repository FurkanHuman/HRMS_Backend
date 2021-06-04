package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.JobPositionService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.JobPositionDao;
import io.kodlama.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(JobPosition jobPosition) {

        Result result = BusinessEngine.run(equalsControl(jobPosition));
        if (!result.isSuccess())
            return new ErrorResult();
        jobPositionDao.save(jobPosition);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
    }

    private Result equalsControl(JobPosition jobPosition) {

        if (jobPositionDao.findByPosition(jobPosition.getPosition()).isPresent())
            return new ErrorResult();
        return new SuccessResult();
    }
}
