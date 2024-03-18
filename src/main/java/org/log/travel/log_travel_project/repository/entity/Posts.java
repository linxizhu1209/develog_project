package org.log.travel.log_travel_project.repository.entity;

import jakarta.persistence.*;
import org.log.travel.log_travel_project.repository.entity.Enum.Category;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_cid")
    private Long postCid;

    @Column(name="author")
    private String author;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="view_count")
    private int viewCount;
    @Column(name="like_count")
    private int likeCount;

    @Column(name="category")
    @Enumerated(EnumType.STRING)
    private Category category;
}
