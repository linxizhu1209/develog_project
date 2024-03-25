package org.log.travel.log_travel_project.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.log.travel.log_travel_project.repository.entity.Enum.Category;

@Getter
@Setter
public class RequestPosting {

    private String title;
    private String content;
    private String category;

}
