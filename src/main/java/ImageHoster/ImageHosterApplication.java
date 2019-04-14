package ImageHoster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Collections;

@SpringBootApplication
@ServletComponentScan
public class ImageHosterApplication {
    public static void main(String[] args) {
        SpringApplication mainApplication = new SpringApplication(ImageHosterApplication.class);
        mainApplication.setDefaultProperties(Collections.singletonMap("server.port","8080"));
        mainApplication.run(args);
    }
}

//run on custom port
@Component
class CustomPort implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8080);
    }
}