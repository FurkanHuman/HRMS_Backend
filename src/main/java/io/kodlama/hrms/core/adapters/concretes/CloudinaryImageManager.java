package io.kodlama.hrms.core.adapters.concretes;

import io.kodlama.hrms.core.adapters.abstracts.ImageService;
import io.kodlama.hrms.core.utilities.readProperty.ReadPropertFile;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.web.multipart.MultipartFile;

public class CloudinaryImageManager implements ImageService {
    private final Cloudinary cloudinary;
    private final ReadPropertFile propertFile;

    public CloudinaryImageManager(Cloudinary cloudinary, ReadPropertFile propertFile)
            throws FileNotFoundException, IOException {
        this.cloudinary = cloudinary;
        this.propertFile = propertFile = new ReadPropertFile("src\\main\\resources\\cloudinary.properties");
        cloudinaryConfig();
    }

    public DataResult<?> save(MultipartFile file) {

        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);

        } catch (IOException io) {
            io.printStackTrace();
        }
        return new ErrorDataResult<Map>();

    }

    private void cloudinaryConfig() throws IOException {
        cloudinary.config.apiKey = propertFile.ReadPropert().getProperty("api_key");
        cloudinary.config.apiSecret = propertFile.ReadPropert().getProperty("api_secret");
        cloudinary.config.cloudName = propertFile.ReadPropert().getProperty("cloud_name");
        cloudinary.config.secure = true;
    }
}
