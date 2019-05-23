package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger를 프로젝트에 설정하기 위한 파일
 * - @EnableSwagger2 를 사용하여 Swagger의 기능을 활성화
 * - Docket 을 반환하는 bean을 설정
 * - 설정을 마치면 자동으로 주소 하나가 생김	/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
//		return new Docket(/*적용시킬 양식*/)
//						.apiInfo(/*앱 정보*/)
//							.select()
//						.apis(/*관리할 대상*/)
//					.build();
		
		ApiInfo app = new ApiInfoBuilder()
														.title("Rest  서비스 테스트")
														.version("0.0.1")
														.description("Rest 서비스 시각화 도구 테스트 설명")
														.license("MIT License")
													.build();
		
		return new Docket(DocumentationType.SWAGGER_2)
							.apiInfo(app).select()
//							 [1] 전체 관리
//							.apis(RequestHandlerSelectors.any())//전체다
//							 [2] 특정 패키지 관리
							.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
								.paths(PathSelectors.any())
							.build();
	}
	
}
