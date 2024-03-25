package org.log.travel.log_travel_project.repository.entity.Enum;

import lombok.Getter;

@Getter
public enum Category {

    SPRING("SPRING"),
    ALGORITHM("ALGORITHM"),
    TROUBLE_SHOOTING("TROUBLE_SHOOTING"),
    ETC("ETC");

    private final String description;

    Category(String description){
        this.description = description;
    }

}
