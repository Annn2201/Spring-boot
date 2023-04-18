package com.example.javaweb_spring_cms.Controller;

import com.example.javaweb_spring_cms.Entities.Member;
import com.example.javaweb_spring_cms.Repositories.MemberRepository;
import com.example.javaweb_spring_cms.Services.MemberService;
import com.example.javaweb_spring_cms.dto.response.MemberResponse;
import com.example.javaweb_spring_cms.dto.response.TestDataDTO;
import com.example.javaweb_spring_cms.dto.response.testDTO;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @PostMapping("/update/save")
//    public String updateMember(@ModelAttribute("member") Member member,
//                               Model model) {
//        memberService.findByUsername(member.getusername());
//        return "redirect:/register?success";
//    }

}





