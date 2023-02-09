package saproject.adminrestclient.DomainClasses.RewardDomain;

public enum RewardType {
    ELEMENT("ELEMENT"), INSCHOOL("INSCHOOL"), GIFT("GIFT");
    private String message;
    RewardType(String message){
        this.message = message;
    }
}
