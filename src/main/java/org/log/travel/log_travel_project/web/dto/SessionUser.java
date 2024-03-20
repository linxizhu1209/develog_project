package org.log.travel.log_travel_project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SessionUser {
    private String name;
    private String email;
    private String picture;
}
