package com.example.javaweb_spring_cms.Repositories;

import com.example.javaweb_spring_cms.Entities.Member;
import com.example.javaweb_spring_cms.dto.response.testDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByUsername(String username);

    @Query("select m.username AS test1, " +
            "c.title AS test2 " +
            "FROM Member m " +
            "JOIN Content c " +
            "ON m.id = c.member.id")
    List<testDTO> testData();
}
