package life.lifearchieve.controller;

import life.lifearchieve.domain.MemberVO;
import life.lifearchieve.service.MemberService;
import life.lifearchieve.repository.MemberDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class LoginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("login.do")
    public String login() {
        return "member/login";
    }

    @RequestMapping("/loginCheck.do")
    public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
        boolean result = memberService.loginCheck(vo, session);
        ModelAndView mav = new ModelAndView();

        if (result == true) {
            mav.setViewName("index");
            mav.addObject("msg", "success");
        }
        else {
            mav.setViewName("member/login");
            mav.addObject("msg", "failure");
        }

        return mav;
    }

    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session) {
        memberService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/login");
        mav.addObject("msg", "logout");
        return mav;
    }
}
