package com.example.javaweb_spring_cms.Services;

import com.example.javaweb_spring_cms.Entities.Member;
import com.example.javaweb_spring_cms.dto.response.MemberResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    List<MemberResponse> listAll();

    MemberResponse findById(int id);

    Member updateById(Member member);
    void save(Member member);
    void deleteById(int id);

    Member findByUsername(String username);
}
