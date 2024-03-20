package org.log.travel.log_travel_project.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Liking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="like_cid")
    private Long likeCid;

    @Column(name="user_cid")
    private Long userCid;

    @Column(name="post_cid")
    private Long postCid;

}
