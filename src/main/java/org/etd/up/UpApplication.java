package org.etd.up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
@SpringBootApplication
public class UpApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UpApplication.class, args);
    }

}
