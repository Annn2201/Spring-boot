package com.example.javaweb_spring_cms.Controller;

import com.example.javaweb_spring_cms.Entities.Member;
import com.example.javaweb_spring_cms.Services.MemberService;
import com.example.javaweb_spring_cms.dto.response.MemberResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "login";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

//    @PostMapping("/login")
//    public String executeLogin() {
//        retur
//    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@ModelAttribute("member") Member member,
                           BindingResult result,
                           Model model) {
    Member existedMember = memberService.findByUsername(member.getusername());
    if (existedMember != null && existedMember.getusername()!= null && !existedMember.getusername().isEmpty()) {
        result.rejectValue("username", null, "Username is not available");
    }
    if (result.hasErrors()) {
        model.addAttribute("member", member);
        return "/register";
    }
    memberService.save(member);
    return "redirect:/register?success";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("member") Member member,
                        BindingResult result,
                        Model model) {
        Member memberLogin = memberService.findByUsername(member.getusername());
//        model.addAttribute("member", member);
        if (memberLogin == null ) {
            result.rejectValue("username", null, "Username is not available");
        }
        if (result.hasErrors()) {
//            model.addAttribute("memberLogined", memberLogin);
            return "/login";
        }
        model.addAttribute("memberLogined", memberLogin);
        return "update";
    }

//    @GetMapping("/update")
//    public String showUpdatePage(Model model, HttpSession session) {
//        Member member = (Member) session.getAttribute("member");
//        return "update";
//    }

    @PostMapping("/update/save")
    public String updateMember(Member member,
                               Model model) {
        memberService.findByUsername(member.getusername());
        return "redirect:/register?success";
    }
}
