package saproject.emailservice.service;

import saproject.emailservice.domain.Email;

import java.util.List;
import java.util.Optional;

public interface IEmailService {
    void addEmail(String incomingEmail);
    List<Email> getAllEmails();

}
