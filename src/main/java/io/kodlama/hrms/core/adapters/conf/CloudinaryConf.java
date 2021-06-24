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

    @Bean
    public Cloudinary cloudinaryConfig() throws IOException {

        Cloudinary cloudinary = new Cloudinary();
        cloudinary.config.apiKey = this.propertFile.ReadPropert("api_key");
        cloudinary.config.apiSecret = this.propertFile.ReadPropert("api_secret");
        cloudinary.config.cloudName = this.propertFile.ReadPropert("cloud_name");

        return cloudinary;

    }
    // @Bean
    // public Cloudinary cloudinaryConfig() throws IOException {

    // return new Cloudinary(ObjectUtils.asMap("cloud_name",
    // this.propertFile.ReadPropert("cloud_name"), "api_key",
    // this.propertFile.ReadPropert("api_key"), "api_secret",
    // this.propertFile.ReadPropert("api_secret")));
    // }

    // @Bean
    // public Cloudinary cloudinaryConfig() {
    // return new Cloudinary(ObjectUtils.asMap("cloud_name", "dh6vglkc1", "api_key",
    // "148529172354494", "api_secret",
    // "pe1Y2TmRKTGV0rDN3Q-VpT1eomQ"));
    // }

    // @Bean
    // public Cloudinary cloudinaryConfig() {
    // return new Cloudinary(ObjectUtils.asMap("cloud_name",
    // environment.getProperty("cloud_name").toString(),
    // "api_key", environment.getProperty("api_key").toString(), "api_secret",
    // environment.getProperty("api_secret").toString()));
    // }

}
