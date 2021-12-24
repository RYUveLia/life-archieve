package life.lifearchieve.controller;

import life.lifearchieve.domain.Member;
import life.lifearchieve.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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


    @PostMapping("login")
    public String loginCheck(LoginForm form, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
        Member member = new Member();
        HttpSession session = req.getSession();

        member.setUserId(form.getUserId());
        member.setUserPw(form.getUserPw());

        boolean result = memberService.loginCheck(member);

        if (result == true) {
            session.setAttribute("member", member);
        }
        else {
            session.setAttribute("member", null);
            rttr.addFlashAttribute("msg", false);
        }

        return "redirect:/";
    }
/*
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
