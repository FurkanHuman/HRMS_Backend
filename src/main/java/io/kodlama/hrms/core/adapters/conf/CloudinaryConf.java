package io.kodlama.hrms.core.adapters.conf;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.kodlama.hrms.core.utilities.readProperty.ReadPropertFile;

@Configuration
public class CloudinaryConf {

    private final ReadPropertFile propertFile;

    @Autowired
    public CloudinaryConf(ReadPropertFile propertFile) throws FileNotFoundException, IOException {
        ReadPropertFile.propertiesPath = "src\\main\\resources\\application.properties";
        this.propertFile = propertFile;
    }

    // @Bean // propertFile.ReadPropert ile url yöntemi
    // public Cloudinary cloudinaryConfig() throws IOException {
    // return new Cloudinary(this.propertFile.ReadPropert("cloudinary_url"));
    // }

    @Bean // set yöntemi.
    public Cloudinary cloudinaryConfig() throws IOException {

        Cloudinary cloudinary = new Cloudinary();
        cloudinary.config.cloudName = this.propertFile.ReadPropert("cloud_name");
        cloudinary.config.apiKey = this.propertFile.ReadPropert("api_key");
        cloudinary.config.apiSecret = this.propertFile.ReadPropert("api_secret");
        cloudinary.config.secure = true; // HTTPS protokülünü kullanmak için gereken.
        return cloudinary;
    }

    // @Bean // Düz url yöntemi. (Java EE) KULLANILABİLİR değil. araştırlıması
    //// lazım.
    // public Cloudinary cloudinaryConfig() {
    // return new Cloudinary();
    // }

    // @Bean // map yöntemi
    // public Cloudinary cloudinaryConfig() throws IOException {

    // // ObjectUtils.asMap() Cloudinaryden import edilecek
    // return new Cloudinary(ObjectUtils.asMap("cloud_name",
    // this.propertFile.ReadPropert("cloud_name"), "api_key",
    // this.propertFile.ReadPropert("api_key"), "api_secret",
    // this.propertFile.ReadPropert("api_secret")));
    // }
    // // secure parametresi https protokolünü açar.

}
