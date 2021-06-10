package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.dtos.JobAdvertismentAddDto;

public interface JobAdvertisementService {

    List<Result> addJobAdvertisement(JobAdvertismentAddDto advertismentAddDto);

    DataResult<List<JobAdvertisementGetDto>> getJobAdvertisement(int jobAdvertisementId);

    DataResult<List<JobAdvertisementGetDto>> getAllJobAdvertisement();

    DataResult<List<JobAdvertisementGetDto>> getJobAdvertisementByJobPositionId(int jobPositionId);

    DataResult<List<JobAdvertisementGetDto>> getJobAdvertisementByCityId(int cityId);

    // DataResult<List<JobAdvertisementGetDto>>
    // getJobAdvertisementByDateRange(LocalDate startDate, LocalDate endDate);

}
