package org.log.travel.log_travel_project.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_cid")
    private Long commentCid;

    @Column(name="author")
    private String author;

    @Column(name="content")
    private String content;

    @Column(name="is_anonymous")
    private boolean isAnonymous;

    @Column(name="postCid")
    private Long postCid;

}
