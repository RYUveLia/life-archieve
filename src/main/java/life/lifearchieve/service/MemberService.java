package life.lifearchieve.service;

import life.lifearchieve.domain.MemberVO;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public boolean loginCheck(MemberVO vo, HttpSession session);
    public MemberVO viewMember(MemberVO vo);
    public void logout(HttpSession session);
}