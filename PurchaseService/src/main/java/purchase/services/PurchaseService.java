package purchase.services;

import org.springframework.stereotype.Service;
import purchase.domain.Element;
import purchase.domain.Reward;
import purchase.domain.RewardType;
import purchase.domain.Student;
import purchase.exception.ElementNotFoundException;
import purchase.exception.NotEnoughScoreException;
import purchase.exception.PurchaseException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService implements IPurchaseService{


    @Override
    public Student buyElement(Student student, Element element) {
        if(student == null || element == null){
            throw new PurchaseException("Student or Element doesn't exist!");
        }
        else{
            if(element.getPrice() > student.getScore()){
                throw new NotEnoughScoreException("Not enough score!");
            }
            else if(checkIfElementTypeExists(student, element) != null ){
                Element toBeDeleted = checkIfElementTypeExists(student, element);
                student.setScore(student.getScore() + toBeDeleted.getPrice());
                student.getAvatar().removeElement(toBeDeleted);
                student.setScore(student.getScore() - element.getPrice());
                student.getAvatar().addElement(element);
            }
            else{
                student.setScore(student.getScore() - element.getPrice());
                student.getAvatar().addElement(element);
            }
        }
        return student;
    }

    @Override
    public Student removeElement(Student student, String elementId) {
        if(student == null){
            throw new PurchaseException("Student doesn't exist!");
        }
        else{
            for(Element e: student.getAvatar().getElementList()){
                if(e.getElementId().equalsIgnoreCase(elementId)){
                    student.setScore(student.getScore() + e.getPrice());
                    student.getAvatar().removeElement(e);
                    return student;
                }
            }

        }
        throw new ElementNotFoundException("Element not found!");
    }

    @Override
    public Student buyReward(Student student, Reward reward) {
        if(student == null || reward == null){
            throw new PurchaseException("Student or Reward doesn't exist!");
        }
        else {
            if (reward.getPrice() > student.getScore()) {
                throw new NotEnoughScoreException("Not enough score to buy reward!");
            }
            else if(checkIfRewardTypeExists(student, reward)){
                throw new PurchaseException("Same Reward type exists!");
            }
            else{
                student.setScore(student.getScore() - reward.getPrice());
                student.addReward(reward);
            }
        }
        return student;
    }

    @Override
    public Student redeemReward(Student student, Element element, String rewardId) {
        if(student == null || element == null){
            throw new PurchaseException("Student or Element doesn't exist!");
        }
        else{
            List<Reward> rewards = student.getRewardList().stream()
                                        .filter(rew->rew.getRewardId().equalsIgnoreCase(rewardId)).collect(Collectors.toList());
            Reward reward = rewards.get(0);
            if(reward == null){
                throw new PurchaseException("You dont have a reward with this reward id!");
            }
            if(reward.getType()!= RewardType.ELEMENT){
                throw new PurchaseException("Reward type is not element!");
            }
            if(reward.getQuantity() == 0){
                student.removeReward(reward);
                throw new PurchaseException("Reward doesnt have enough quantity!");

            }
            else if(checkIfElementTypeExists(student, element) != null ){
                Element toBeDeleted = checkIfElementTypeExists(student, element);
                student.setScore(student.getScore() + toBeDeleted.getPrice());
                student.getAvatar().removeElement(toBeDeleted);
                student.getAvatar().addElement(element);
                student.updateRewardQuantity(rewardId);
                return student;
            }
            else {
                student.getAvatar().addElement(element);
                student.updateRewardQuantity(rewardId);
                return student;
            }
        }
    }

    @Override
    public Student giveReward(Student student, Reward reward) {
        if(student == null || reward == null){
            throw new PurchaseException("Student or Element doesn't exist!");
        }
        else {
            student.getRewardList().add(reward);
            return student;
        }
    }


    private Element checkIfElementTypeExists(Student student, Element element){
        for(Element e: student.getAvatar().getElementList()){
            if(e.getType().equals(element.getType()))
                return e;
        }
        return null;
    }

    private boolean checkIfRewardTypeExists(Student student, Reward reward){
        for(Reward r: student.getRewardList()){
            if(r.getType().equals(reward.getType()))
                return true;
        }
        return false;
    }
}
