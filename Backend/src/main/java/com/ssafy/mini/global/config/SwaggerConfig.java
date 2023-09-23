package com.ssafy.mini.global.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // http://localhost:8080/swagger-ui.html

    private static final String SECURITY_SCHEME_NAME = "authorization";


    @Bean Docket memberApi() {
        return getDocket("com.ssafy.mini.domain.member.controller", "회원 관리", Predicates.or(
                PathSelectors.ant("/member/**")
        ));
    }
    @Bean Docket authApi() {
        return getDocket("com.ssafy.mini.domain.auth.controller", "토큰 갱신", Predicates.or(
                PathSelectors.ant("/auth/**")
        ));
    }

    @Bean Docket nationApi() {
        return getDocket("com.ssafy.mini.domain.nation.controller", "국가 관리", Predicates.or(
                PathSelectors.ant("/nation/**")
        ));
    }

    @Bean Docket homeApi() {
        return getDocket("com.ssafy.mini.domain.home.controller", "홈 관리", Predicates.or(
                PathSelectors.ant("/home/**")
        ));
    }

    @Bean Docket jobApi() {
        return getDocket("com.ssafy.mini.domain.job.controller", "직업 관리", Predicates.or(
                PathSelectors.ant("/job/**")
        ));
    }

    public Docket getDocket(String base, String groupName, Predicate<String> predicate) {
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("Authorization")
                .description("Access Tocken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        List<Parameter> aParameters = new ArrayList<>();
        aParameters.add(aParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(aParameters)
                .groupName(groupName).select()
                .apis(RequestHandlerSelectors.basePackage(base)).paths(predicate)
                .apis(RequestHandlerSelectors.any()).build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().displayRequestDuration(true).validatorUrl("").build();
    }


}
