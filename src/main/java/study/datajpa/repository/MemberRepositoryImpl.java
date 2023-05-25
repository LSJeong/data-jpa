package study.datajpa.repository;

import lombok.RequiredArgsConstructor;
import study.datajpa.entitiy.Member;

import javax.persistence.EntityManager;
import java.util.List;

//규칙: 리포지토리 인터페이스 이름 + Impl
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final EntityManager em;

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m").getResultList();
    }
}
