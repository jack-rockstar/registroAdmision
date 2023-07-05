package proyecto.pontificia.mi.registroadmision.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /*
            @Override
            public  void  addCorsMapping(CorsRegistry registry){
                registry
                        .addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");

                registry
                        .addMapping("/login")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .exposedHeaders("*");
            };
             */

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/api/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");

                registry
                        .addMapping("/login")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .exposedHeaders("*");
                WebMvcConfigurer.super.addCorsMappings(registry);
            }

        };
    }
}
