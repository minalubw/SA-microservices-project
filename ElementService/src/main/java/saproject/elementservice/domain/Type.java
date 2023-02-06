package saproject.elementservice.domain;

public enum Type {
    HEAD("HEAD"), HAIR("HAIR"), EYE("EYE"), EYEBROW("EYEBROW"), NOSE("NOSE"), MOUTH("MOUTH"), EARS("MOUTH"), BODY("MOUTH"), HAT("MOUTH"), TOP("MOUTH"), TOPCOLOR("MOUTH"), HATCOLOR("MOUTH");

    private String type;
    Type(String type){
        this.type = type;
    }

    public String getType() {

        return type;
    }
}
