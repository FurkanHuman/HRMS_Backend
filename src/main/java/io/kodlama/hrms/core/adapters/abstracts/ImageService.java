package io.kodlama.hrms.core.adapters.abstracts;

import org.springframework.web.multipart.MultipartFile;

import io.kodlama.hrms.core.utilities.results.DataResult;

public interface ImageService {
    DataResult<?> save(MultipartFile file);

}
