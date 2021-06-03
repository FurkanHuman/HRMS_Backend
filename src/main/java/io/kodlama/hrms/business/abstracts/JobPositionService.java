package io.kodlama.hrms.business.abstracts;

import java.util.List;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
    Result add(JobPosition jobPosition);

    DataResult<List<JobPosition>> getAll();
}
