package core.emr.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
//@EnableWebFlux
public class CorsConfig implements WebFluxConfigurer{

     @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","PUT","POST","DELETE")
                .allowedHeaders("*");
                //.maxAge(3600);
    }
    
//    @Bean
//    public WebFluxConfigurer getCorsConfiguration(){
//        return new WebFluxConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET","POST","PUT","DELETE")
//                        .allowedHeaders("*");
//            }
//        };
//    }
}
