package org.log.travel.log_travel_project.repository.entity;


public enum Role {
    GUEST("ROLE_GUEST"),
    OWNER("ROLE_OWNER");

    private final String key;

    Role(String key){
        this.key = key;
    }

    public String getKey(){
        return key;
    }
}
