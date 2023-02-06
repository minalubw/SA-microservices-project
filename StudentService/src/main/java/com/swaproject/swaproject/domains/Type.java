package com.swaproject.swaproject.domains;

public enum Type {
    ELEMENT("ELEMENT"), INSCHOOL("INSCHOOL"), GIFT("GIFT");
    private String message;
    Type(String message){
        this.message = message;
    }
}
