package com.example.DBProjects.Library.entities.enums;

public enum Stock {

    HAVE(1),
    DONT_HAVE(2),
    WANT(3),
    BORROWED(4);

    private final int code;

    Stock(int code){this.code = code;}

    public int getCode(){return code;}

    public static Stock valueOf(int code){
        for (Stock s : Stock.values()){
            if (s.getCode() == code){
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid Stock code");
    }
}
