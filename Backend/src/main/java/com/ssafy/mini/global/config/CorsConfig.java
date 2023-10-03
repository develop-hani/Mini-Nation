package com.ssafy.mini.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // 허용할 url
        config.addAllowedOrigin("https://j9a508.p.ssafy.io");
        config.addAllowedOrigin("http://j9a508.p.ssafy.io");
        config.addAllowedOrigin("https://minination.site");
        config.addAllowedOrigin("http://localhost:3000");
        // 허용할 http method
        config.addAllowedMethod("*");
        // 허용할 header
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;

    }

}
