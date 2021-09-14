package edu.spring.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//현재 부트프로젝트 http://localhost:9090/xxxxx |||  src/main/resources/static 폴더 이미지들
		registry.addResourceHandler("/upload/**").addResourceLocations("c:/kdigital2/upload/");
	}
	
}
