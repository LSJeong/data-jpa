package study.datajpa.repository;

import org.springframework.beans.factory.annotation.Value;

//인터페이스 기반 Open Proejctions
//프로퍼티 형식(getter)의 인터페이스를 제공하면, 구현체는 스프링 데이터 JPA가 제공
public interface UsernameOnly {

    //이렇게 SpEL문법을 사용하면, DB에서 엔티티 필드를 다 조회해온 다음에 계산한다! 따라서 JPQL SELECT 절 최적화가 안된다.
    //@Value("#{target.username + ' ' + target.age + ' ' + target.team.name}")
    String getUsername();
}
