package saproject.emailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saproject.emailservice.domain.Email;
import saproject.emailservice.repository.EmailDAO;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService implements IEmailService{

    @Autowired
    private EmailDAO emailDAO;

    public void addEmail(String incomingEmail) {
        int lastEmailId;
        int newEmailId;
        String[] info = incomingEmail.split(",");
        Email email;
        List<Email> emails =getAllEmails();
        if(emails.size()==0) {
            newEmailId=1;
        }
        else{
            lastEmailId = emails.get(emails.size()-1).getId();
            newEmailId = lastEmailId+1;
        }
        if(info[3].equals("teacher")){
            String message =  "Dear "+info[0]+" "+info[1]+",\n\n"
                    +"Welcome to the school!\n\n"
                    +"Best regards,\n"
                    +"School management";
            email = new Email(newEmailId,info[2],message,false);
        }
           
        else{
            String message =  "Dear "+info[0]+" "+info[1]+",\n\n"
                    +"Welcome to "+info[2]+ " class\n\n"
                    +"Best regards,\n"
                    +"School management";
            email = new Email(newEmailId,info[0]+"."+info[1]+"@school.edu",message,false);
        }
        emailDAO.save(email);
    }

    @Override
    public Optional<Email> getEmail(int id) {
            return emailDAO.findById(id);
    }

    @Override
    public List<Email> getAllEmails() {
        return emailDAO.findAll();
    }

}

