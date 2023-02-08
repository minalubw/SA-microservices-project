package purchase.services;

import org.springframework.stereotype.Service;
import purchase.domain.Element;
import purchase.domain.Student;
import purchase.exception.ElementNotFoundException;
import purchase.exception.NotEnoughScoreException;
import purchase.exception.PurchaseException;
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
            else if(checkIfExists(student, element) != null ){
                Element toBeDeleted = checkIfExists(student, element);
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


    private Element checkIfExists(Student student, Element element){
        for(Element e: student.getAvatar().getElementList()){
            if(e.getType().equals(element.getType()))
                return e;
        }
        return null;
    }
}
