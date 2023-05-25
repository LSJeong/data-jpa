package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.dto.MemberDto;
import study.datajpa.entitiy.Member;
import study.datajpa.repository.MemberRepository;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    //도메인 클래스 컨버터
    //HTTP 파라미터로 넘어온 엔티티의 아이디로 엔티티 객체를 찾아서 바인딩
    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member){
        return member.getUsername();
    }

    //페이징 : 글로벌 설정 application.yml에서 수정가능
    //개별 설정 : @PageableDefault , 이게 우선권
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 5, sort = "username") Pageable pageable){
        Page<Member> page = memberRepository.findAll(pageable);  //엔티티로 반환하지말자
        Page<MemberDto> map = page.map(member -> new MemberDto(member));  //Dto로 반환
        //==>줄여쓸수있음 Page<MemberDto> map = page.map(MemberDto::new);
        return map;
    }

    @PostConstruct
    public void init(){
        for(int i = 0; i < 100; i++){
            memberRepository.save(new Member("user"+i, i));
        }
    }
}
