package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.School;
import io.kodlama.hrms.entities.dtos.SchoolAddDto;

public interface SchoolService {

    DataResult<List<School>> getAll();

    List<Result> add(SchoolAddDto schoolAddDto);

}
