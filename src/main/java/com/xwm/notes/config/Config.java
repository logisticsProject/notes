package com.xwm.notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class Config {

    public static String[] oringins={
            "127.0.0.1:8080",
            "localhost:8080"
    };


    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        this.addAllowOrigin(corsConfiguration);
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }

    private void addAllowOrigin(CorsConfiguration corsConfiguration) {
        for (String oringin:oringins
                ) {
            corsConfiguration.addAllowedOrigin("http://"+oringin);
            corsConfiguration.addAllowedOrigin("https://"+oringin);
        }

    }

}


