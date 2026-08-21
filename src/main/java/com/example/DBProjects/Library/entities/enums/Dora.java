package com.example.DBProjects.Library.entities.enums;

import java.util.Locale;

public enum Dora {

    ALIVE(1),
    NBU(2);

    private final int code;

    Dora(int code){this.code = code;}

    public int getCode(){return code;}

    public static Dora valueOf(int code){
        for(Dora m : Dora.values()){
            if (m.getCode() == code){
                return m;
            }
        }
        throw new IllegalArgumentException("Status code not valid.");
    }
    public static Dora textOf(String txt){
        if (txt == null) return null;

        String formatedTxt = txt.trim().toUpperCase();

        if (formatedTxt.equals("VIVO") || formatedTxt.equals(("VIVA"))){
            return ALIVE;
        } else if (formatedTxt.equals("MORTA") || formatedTxt.equals("MORTO")){
            return NBU;
        }
        throw new IllegalArgumentException("Status unknown: " + txt);
    }

}
