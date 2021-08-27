package com.hetting.hottable.common;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描包下使用Swagger的controller
                .apis(RequestHandlerSelectors.basePackage("com.hetting.hottable.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("齐芯电子有限公司","http://localhost:3000/login","");
        return new ApiInfoBuilder()
                .title("热力抄表系统")
                .description("接口文档")
                .termsOfServiceUrl("http://blog.csdn.net/wu_zi")
                .contact(contact)
                .version("1.0")
                .build();
    }

}