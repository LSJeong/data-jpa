package study.datajpa.repository;

//중첩 구조 처리
//프로젝션 대상이 root 엔티티면 유용하다.
//프로젝션 대상이 root 엔티티를 넘어가면 JPQL SELECT 최적화가 안된다!
public interface NestedClosedProjections {

    String getUsername();
    TeamInfo getTeam();

    interface TeamInfo{
        String getName();
    }
}
