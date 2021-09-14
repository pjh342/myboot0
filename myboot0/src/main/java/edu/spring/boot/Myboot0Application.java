package edu.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import mybatis.EmpDAO;
import mybatis.EmpMybatisController;
import upload.UploadController;
import upload.UploadDAO;

@SpringBootApplication
@ComponentScan(basePackageClasses = UploadController.class)//upload패키지의 컨트롤러만 인식
@ComponentScan(basePackageClasses = EmpMybatisController.class)
@ComponentScan//뒤에 아무클래스도 없을 시 현재 패키지의 컨트롤러
//edu.spring.boot 패키지 컨트롤러 (현재 패키지의 컨트롤러 인식) 위에가 없을 경우
@MapperScan(basePackageClasses = EmpDAO.class)
@MapperScan(basePackageClasses = UploadDAO.class)
public class Myboot0Application {

	public static void main(String[] args) {
		SpringApplication.run(Myboot0Application.class, args);
		
		System.out.println("부트 실행 중");
	}

}
