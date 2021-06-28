package io.kodlama.hrms.core.adapters.conf;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CloudinaryConf {

    private final Environment environment;

    @Autowired
    public CloudinaryConf(Environment environment) {
        this.environment = environment;
    }

    // private final ReadPropertFile propertFile;

    // public CloudinaryConf(ReadPropertFile propertFile, Environment environment)
    // throws FileNotFoundException, IOException {
    // ReadPropertFile.propertiesPath =
    // "src\\main\\resources\\application.properties"; // ReadPropertFile
    // Environment kullanılamadığı zaman kullanılabilir.
    // this.propertFile = propertFile;
    // this.environment = environment;
    // }

    @Bean // Düz url yöntemi. Environment class kullanıması ve enjekte edilmesi gerekiyor.
    public Cloudinary cloudinaryConfig() {
        System.out.println("Cloudinary V " + Cloudinary.VERSION);
        return new Cloudinary(environment.getProperty("CLOUDINARY_URL"));
    }

    // @Bean // propertFile.ReadPropert ile url yöntemi
    // public Cloudinary cloudinaryConfig() throws IOException {
    // return new Cloudinary(this.propertFile.ReadPropert("cloudinary_url"));
    // }

    // @Bean // set yöntemi.
    // public Cloudinary cloudinaryConfig() throws IOException {
    // Cloudinary cloudinary = new Cloudinary();
    // cloudinary.config.cloudName = this.propertFile.ReadPropert("cloud_name");
    // cloudinary.config.apiKey = this.propertFile.ReadPropert("api_key");
    // cloudinary.config.apiSecret = this.propertFile.ReadPropert("api_secret");
    // cloudinary.config.secure = true; // HTTPS protokülünü kullanmak için gereken.
    // return cloudinary;
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
