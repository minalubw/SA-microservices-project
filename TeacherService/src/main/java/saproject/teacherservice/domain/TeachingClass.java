package saproject.teacherservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeachingClass {
    private String group; // like entry i.e. August 2019
    private String year;
}
