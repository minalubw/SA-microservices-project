package teacherclient.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

        private String fName;
        private String lName;

        private String studentNumber;
        private int score;
        //private Avatar avatar;
        //private List<Reward> rewards;

        private  School school;
        private TeachingClass teachingClass;


    }


