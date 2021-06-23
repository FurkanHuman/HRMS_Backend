package io.kodlama.hrms.core.adapters.conf;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConf {

    @Autowired
    public CloudinaryConf() {
        super();
    }

    @Bean
    public Cloudinary cloudinaryConfig() {
        return new Cloudinary(ObjectUtils.asMap("cloud_name", "dh6vglkc1", "api_key", "148529172354494", "api_secret",
                "pe1Y2TmRKTGV0rDN3Q-VpT1eomQ"));
    }

    // @Bean
    // public Cloudinary cloudinaryConfig() {
    // return new Cloudinary(ObjectUtils.asMap("cloud_name",
    // environment.getProperty("cloud_name").toString(),
    // "api_key", environment.getProperty("api_key").toString(), "api_secret",
    // environment.getProperty("api_secret").toString()));
    // }

}
