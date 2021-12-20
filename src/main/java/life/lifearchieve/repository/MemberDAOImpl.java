package life.lifearchieve.repository;

import life.lifearchieve.domain.Article;
import life.lifearchieve.domain.MemberVO;
import life.lifearchieve.repository.MemberDAO;
import life.lifearchieve.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberDAOImpl implements MemberDAO {
    private final EntityManager em;

    public MemberDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean loginCheck(MemberVO vo) {
        MemberService memberService = em.find(MemberService.class, vo.getUserId());
        return (Optional.ofNullable(memberService) == null) ? false : true;
    }

    @Override
    public MemberVO viewMember(MemberVO vo) {
        MemberVO memberVO = em.find(MemberVO.class, vo.getUserId());
        return memberVO;
    }

    @Override
    public void logout(HttpSession session) {

    }
}
