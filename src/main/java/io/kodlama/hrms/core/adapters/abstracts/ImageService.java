package io.kodlama.hrms.core.adapters.abstracts;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String save(MultipartFile file);

}
