package com.example.javaweb_spring_cms.Repositories;

import com.example.javaweb_spring_cms.Entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
}
