package io.kodlama.hrms.core.adapters.concretes;

import io.kodlama.hrms.core.adapters.abstracts.ImageService;
import java.util.Map;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryImageManager implements ImageService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryImageManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String save(MultipartFile file) {

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return uploadResult.get("url").toString();

        } catch (Exception io) {
            return null;
        }
    }
}