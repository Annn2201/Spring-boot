package com.example.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentResponse {
    private int cid;
    private String title;
    private String brief;
    private String body;
    private com.example.javaweb_spring_cms.Entities.Member Member;
}
