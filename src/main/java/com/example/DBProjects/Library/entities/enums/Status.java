package com.example.DBProjects.Library.entities.enums;

public enum Status {

    READ(1),
    READING(2),
    NOT_READ(3);

    private final int code;

    Status(int code){this.code = code;}

    public int getCode(){return code;}

    public static Status valueOf(int code){
        for(Status s : Status.values()){
            if (s.getCode() == code){
                return s;
            }
        }
        throw new IllegalArgumentException("Status code not valid.");
    }

}
