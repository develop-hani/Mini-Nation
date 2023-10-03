package com.ssafy.mini.global.config;


import com.ssafy.mini.global.auth.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .cors().and()
                .csrf().disable()
                .authorizeRequests(requests -> requests
                        .antMatchers(HttpMethod.OPTIONS).permitAll()  // preflight 로 보내는 요청

                        // swagger 요청은 모두 허용
                        .antMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/swagger/**").permitAll()

                        // member 요청은 일부 허용
                        .antMatchers(HttpMethod.POST, "/member/login").permitAll()
                        .antMatchers(HttpMethod.POST, "/member/join").permitAll()
                        .antMatchers(HttpMethod.POST, "/member/id").permitAll()

                        // auth 테스트
                        .antMatchers(HttpMethod.GET, "/auth/test").permitAll()

                        // s3 이미지 업로드
                        .antMatchers(HttpMethod.POST, "/s3/upload").permitAll()
                        .antMatchers(HttpMethod.POST, "/corporation/register").permitAll()

                        // 그 외 요청은 모두 인증 필요
                        .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않으므로 STATELESS 설정
                )
                .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class)
                .build();
    }
}
