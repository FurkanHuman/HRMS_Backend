package io.kodlama.hrms.core.adapters.cocretes;

import io.kodlama.hrms.core.adapters.abstracts.CloudinaryService;
import com.cloudinary.*;

public class CloudinaryAdapter implements CloudinaryService {

    public static void upload() {
        Cloudinary cloudinary = new Cloudinary();
        cloudinary.uploader();

    }
}
