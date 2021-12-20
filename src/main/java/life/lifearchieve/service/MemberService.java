package life.lifearchieve.service;


import life.lifearchieve.domain.Article;
import life.lifearchieve.domain.Member;
import life.lifearchieve.repository.ArticleRepository;
import life.lifearchieve.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public String register(Member member) {
        memberRepository.register(member);
        return member.getUserId();
    }

    //로그인
    //회원수정
    //회원탈퇴
}