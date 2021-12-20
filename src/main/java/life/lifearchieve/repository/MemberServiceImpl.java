package life.lifearchieve.repository;

import life.lifearchieve.domain.MemberVO;
import life.lifearchieve.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDAO memberDao;

    @Override
    public boolean loginCheck(MemberVO vo, HttpSession session) {
        boolean result = memberDao.loginCheck(vo);
        if (result) {
            MemberVO vo2 = viewMember(vo);

            session.setAttribute("userId", vo2.getUserId());
            session.setAttribute("userName", vo2.getUserName());
        }

        return result;
    }

    @Override
    public MemberVO viewMember(MemberVO vo) {
        return memberDao.viewMember(vo);
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
