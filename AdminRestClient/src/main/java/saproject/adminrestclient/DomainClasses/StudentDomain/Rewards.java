package saproject.adminrestclient.DomainClasses.StudentDomain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rewards {
    private String id;
    List<Reward> rewardsList = new ArrayList<>();



}
