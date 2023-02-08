package purchase.services;

import purchase.domain.Element;
import purchase.domain.Reward;
import purchase.domain.Student;

public interface IPurchaseService {
    Student buyElement(Student student, Element element);
    Student removeElement(Student student, String elementId);
    Student buyReward(Student student, Reward reward);
    Student redeemReward(Student student, Element element, String rewardId);
}
