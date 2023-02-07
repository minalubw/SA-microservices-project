package com.swaproject.swaproject.domains;

public enum ElementType {
    HEAD("HEAD"), HAIR("HAIR"), EYE("EYE"), EYEBROW("EYEBROW"), NOSE("NOSE"), MOUTH("MOUTH"), EARS("MOUTH"), BODY("MOUTH"), HAT("MOUTH"), TOP("MOUTH"), TOPCOLOR("MOUTH"), HATCOLOR("MOUTH");

    private String type;
    ElementType(String type){
        this.type = type;
    }

    public String getType() {

        return type;
    }
}
