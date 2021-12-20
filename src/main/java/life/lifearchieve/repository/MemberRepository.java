package life.lifearchieve.repository;

import life.lifearchieve.domain.Member;

import javax.servlet.http.HttpSession;

public interface MemberRepository {
    public Member register(Member member);
    public boolean loginCheck(Member vo);
    public Member viewMember(Member vo);
    public void logout(HttpSession session);
}
