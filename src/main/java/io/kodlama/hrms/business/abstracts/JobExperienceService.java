package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.JobExperience;
import io.kodlama.hrms.entities.dtos.JobExperienceAddDto;

public interface JobExperienceService {

    List<Result> add(JobExperienceAddDto jobExperienceAddDto);

    DataResult<List<JobExperience>> getAll();
}
