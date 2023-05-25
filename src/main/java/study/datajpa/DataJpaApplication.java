package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing  //저장시점에 저장데이터만 입력하고 싶으면 @EnableJpaAuditing(modifyOnCreate = false)
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	//등록자, 수정자를 처리해주는 AuditorAware 스프링 빈 등록
	@Bean
	public AuditorAware<String> auditorProvider(){
		//실무에서는 세션 정보나, 스프링 시큐리티 로그인 정보에서 ID를 받음
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
