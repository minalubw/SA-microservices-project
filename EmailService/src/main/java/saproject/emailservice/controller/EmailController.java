package saproject.emailservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saproject.emailservice.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    @KafkaListener(topics = "teacher")
    public void sendEmail(@Payload String teacherEmail) {
        emailService.addEmail(teacherEmail+"teacher");
    }
    @KafkaListener(topics = "student")
    public void sendEmailToStudent(@Payload String details) {
        emailService.addEmail(details+"student");
    }
}
