package com.example.DBProjects.Library.entities.enums;

public enum Material {

    PHYSICAL(1),
    READING(2),
    NOT_READ(3);

    private final int code;

    Material(int code){this.code = code;}

    public int getCode(){return code;}

    public static Material valueOf(int code){
        for(Material m : Material.values()){
            if (m.getCode() == code){
                return m;
            }
        }
        throw new IllegalArgumentException("Status code not valid.");
    }

}
