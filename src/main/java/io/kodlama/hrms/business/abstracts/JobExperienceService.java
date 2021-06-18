package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
}
