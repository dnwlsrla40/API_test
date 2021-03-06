package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any()) // controller 내용을 읽어 mapping된 resource들을 문서화 PathSelectors.ant("/v1/**")와 같은 방식으로 특정 문서에 대한 설명과 작성자 정보를 노출 시킬 수 있다.
//                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .useDefaultResponseMessages(false); // 기본으로 세팅되는 200, 401, 403, 303 에러 표시 X
    }

    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder().title("Spring API Documentation")
                .description("앱 개발 시 사용되는 서버 API에 대한 연동 문서입니다.")
                .license("happydaddy").licenseUrl("http://daddyprogrammer.org").version("1").build();
    }
}
