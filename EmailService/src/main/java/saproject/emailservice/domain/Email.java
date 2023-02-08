package saproject.emailservice.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Id
    private int id;
    private String email;
    private String message;
    private boolean isRead=false;
}
