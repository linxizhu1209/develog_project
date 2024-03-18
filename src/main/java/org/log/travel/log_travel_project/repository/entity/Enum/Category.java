package org.log.travel.log_travel_project.repository.entity.Enum;

public enum Category {

    SPRING("스프링"),
    ALGORITHM("알고리즘"),
    ETC("기타");

    private final String korean;

    Category(String korean){
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
