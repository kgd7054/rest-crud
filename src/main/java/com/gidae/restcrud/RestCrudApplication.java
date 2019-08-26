package com.gidae.restcrud;

import com.gidae.restcrud.domain.Basic;
import com.gidae.restcrud.domain.Profile;
import com.gidae.restcrud.repository.BasicRepository;
import com.gidae.restcrud.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class RestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner runnerBasic(BasicRepository basicRepository){
		return args -> {
			basicRepository.save(Basic.builder()
					.name("홍길동")
					.label("CEO")
					.email("hong@gmail.com")
					.phone("012-345-6789")
					.build());
			basicRepository.save(Basic.builder()
					.name("장길산")
					.label("CFO")
					.email("jang@gmail.com")
					.phone("123-456-7890")
					.build());
			basicRepository.save(Basic.builder()
					.name("춘향이")
					.label("CTO")
					.email("chun@gmail.com")
					.phone("234-567-8901")
					.build());
		};
	}

	@Bean
	public CommandLineRunner runnerProfile(ProfileRepository profileRepository){
		return args -> {
			profileRepository.save(Profile.builder()
					.network("트위터")
					.userName("@home")
					.url("https://www.twitter.com/@home")
					.createDat(LocalDateTime.now())
					.build());
			profileRepository.save(Profile.builder()
					.network("페이스북")
					.userName("@home")
					.url("https://www.facebook.com/@home")
					.createDat(LocalDateTime.now())
					.build());
			profileRepository.save(Profile.builder()
					.network("인스타그램")
					.userName("@home")
					.url("https://www.instagram.com/@home")
					.createDat(LocalDateTime.now())
					.build());
		};
	}
}
