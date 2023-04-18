package com.example.javaweb_spring_cms.Services.Impl;

import com.example.javaweb_spring_cms.Entities.Member;
import com.example.javaweb_spring_cms.Repositories.MemberRepository;
import com.example.javaweb_spring_cms.Services.MemberService;
import com.example.javaweb_spring_cms.dto.response.MemberResponse;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<MemberResponse> listAll() {
        List<Member> members = memberRepository.findAll();
//        List<MemberResponse> memberResponses = new ArrayList<>();
//        for (Member member : members) {
//            memberResponses.add(MemberResponse.builder()
//                    .username(member.getusername())
//                    .firstName(member.getfirstName())
//                    .lastName(member.getlastName())
//                    .email(member.getemail())
//                    .phone(member.getphone())
//                    .description(member.getdescription())
//                    .build());
//        }

        return members.stream().map(member -> MemberResponse.builder()
                .id(member.getId())
                .username(member.getusername())
                .firstName(member.getfirstName())
                .lastName(member.getlastName())
                .email(member.getemail())
                .phone(member.getphone())
                .description(member.getdescription())
                .build()).toList();
    }

    @Override
    public MemberResponse findById(int id) {
        Member member = memberRepository.findById(id).orElse(null);
        return MemberResponse.builder()
                .id(member.getId())
                .username(member.getusername())
                .firstName(member.getfirstName())
                .lastName(member.getlastName())
                .email(member.getemail())
                .phone(member.getphone())
                .description(member.getdescription())
                .build();
    }

    @Override
    public Member updateById(Member member) {
        Optional<Member> oldMember = memberRepository.findById(member.getId());
        Member newMember = oldMember.orElse(new Member());
        newMember.setFirstName(member.getfirstName());
        newMember.setLastName(member.getlastName());
        newMember.setEmail(member.getemail());8
        newMember.setPhone(member.getphone());
        newMember.setDescription(member.getdescription());
        return newMember;
    }

    @Override
    public void save(Member member) {
        member.setCreateddate(Date.valueOf(LocalDate.now()));
        memberRepository.save(member);
    }

    @Override
    public void deleteById(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member findByUsername(String username) {
        Member member = memberRepository.findByUsername(username);
        return member;
    }
}
