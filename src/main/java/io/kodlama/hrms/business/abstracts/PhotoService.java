package io.kodlama.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.Photo;

public interface PhotoService {

    DataResult<List<Photo>> getAll();

    List<Result> add(MultipartFile file, int candidateUserId);
}
