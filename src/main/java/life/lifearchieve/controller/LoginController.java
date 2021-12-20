package life.lifearchieve.controller;

import life.lifearchieve.domain.Member;
import life.lifearchieve.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/*")
public class LoginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("login")
    public String login() {
        return "member/login";
    }

    /*
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@ModelAttribute Member vo, HttpSession session) {
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

    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session) {
        memberService.logout(session);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/login");
        mav.addObject("msg", "logout");
        return mav;
    }
*/
    @GetMapping("register")
    public String registerMember() {
        return "member/register";
    }

    @PostMapping("register")
    public String register(LoginForm form) {
        Member memberVO = new Member();

        memberVO.setUserId(form.getUserId());
        memberVO.setUserPw(form.getUserPw());
        memberVO.setUserName(form.getUserName());

        memberService.register(memberVO);

        return "redirect:/";
        //memberService.
    }
}
