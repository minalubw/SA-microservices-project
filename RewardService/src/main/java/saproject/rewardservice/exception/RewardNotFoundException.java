package saproject.rewardservice.exception;

public class RewardNotFoundException extends RuntimeException{
    private String message;

    public RewardNotFoundException(String message){
        this.message = message;
    }
}
