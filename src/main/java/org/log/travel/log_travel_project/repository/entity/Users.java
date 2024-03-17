package org.log.travel.log_travel_project.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCid;

    private String oauthId;

    private String name;
    private String email;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Users update(String name, String picture){
        this.name = name;
        this.imageUrl = picture;
        return this;
    }

}
