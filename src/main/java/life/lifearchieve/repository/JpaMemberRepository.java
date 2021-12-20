package life.lifearchieve.repository;

import life.lifearchieve.domain.Member;
import life.lifearchieve.service.MemberService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Repository
public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member register(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public boolean loginCheck(Member vo) {
        MemberService memberService = em.find(MemberService.class, vo.getUserId());
        return (Optional.ofNullable(memberService) == null) ? false : true;
    }

    @Override
    public Member viewMember(Member vo) {
        Member memberVO = em.find(Member.class, vo.getUserId());
        return memberVO;
    }

    @Override
    public void logout(HttpSession session) {

    }
}
