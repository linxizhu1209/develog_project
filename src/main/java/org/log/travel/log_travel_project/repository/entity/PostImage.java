package org.log.travel.log_travel_project.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@Table(name = "post_image_table")
public class PostImage {

        @Id
        @Column(name = "post_image_cid")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long postImageCid;

    /**
     * 일반적으로 파일명이 아닌 UUID로 저장함.
     * 클라이언트가 보낸 파일명으로 저장할 경우 중복되는 경우가 있을 수 있음
     */
        @Column(name = "UUID")
        private String UUID;

        @Column(name = "file_url")
        private String fileUrl;

        @Column(name = "file_ext")
        private String fileExt; // 파일 확장자 .png jpg 등

        @Column(name="post_cid")
        private Long postCid;

    }

