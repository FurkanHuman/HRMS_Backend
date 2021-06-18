package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.SchoolType;
import io.kodlama.hrms.entities.dtos.SchoolTypeDto;

public interface SchoolTypeService {

    DataResult<List<SchoolType>> getAll();

    List<Result> add(SchoolTypeDto schoolTypeDto);
}
