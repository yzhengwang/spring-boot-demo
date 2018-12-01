package com.ordin.utils.plugins.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMDg3NzYzOTc5NTI3MzcyOCIsImlhdCI6MTUzNzk0NzYxNiwic3ViIjoie1wiaWRcIjoxMjYsXCJhY2NvdW50XCI6XCIxNTA3ODgxMjUyOVwiLFwicGhvbmVcIjpcIlwiLFwibmlja25hbWVcIjpcIjExMTFcIixcInJlYWxuYW1lXCI6XCLnjKvnjKtcIixcImZhY2VcIjpcImh0dHA6Ly90aGlyZHd4LnFsb2dvLmNuL21tb3Blbi92aV8zMi9YVVZZTVBrY3FGQTF1bnVxMk5KcXRQbVdQUXJNQmdYVngzczBOOVB6U1FVbmFYSTZpYU1UT1FpYnNvb2haN01PclRuM09zMkZnTm5ER2lhVW5NY0JpYzIyUVEvMTMyXCIsXCJzZXhcIjowLFwibGFzdExvZ2luSXBcIjpcIjEyNy4wLjAuMVwiLFwibG9naW5Db3VudFwiOjEyOSxcImlkQ2FyZFwiOlwiXCIsXCJlbWFpbFwiOlwiXCIsXCJ5eXBheUNvZGVcIjpcIlwifSIsImV4cCI6MTUzODAzNDAxNn0.6vav_m1H0KdLeaM2eQ8Raanm7LHZegmQcnqQCqjmX_Y";
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Test API")
                        .contact(new Contact("ORDIN Co.,Ltd. ", "https://yzhengwang.github.io", "1402205524@qq.com"))
                        .version("v 1.0.0")
                        .description("测试接口文档")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ordin.utils.controller"))
                .build()
                .globalOperationParameters(new ArrayList<Parameter>() {{
                    add(new ParameterBuilder()
                            .name("Authorization")
                            .description("token")
                            .modelRef(new ModelRef("string"))
                            .parameterType("header")
                            .required(false)
                            .defaultValue(token)
                            .build()
                    );
                }});
    }

}
