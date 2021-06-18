package io.kodlama.hrms.business.abstracts;

import java.io.File;
import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Photo;

public interface PhotoService {

    DataResult<List<Photo>> getAll();

    List<Result> add(File file, int candidateUserId);
}
