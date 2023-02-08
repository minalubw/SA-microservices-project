package purchase.services;

import purchase.domain.Element;
import purchase.domain.Student;

public interface IPurchaseService {
    Student buyElement(Student student, Element element);
    Student removeElement(Student student, String elementId);
}
