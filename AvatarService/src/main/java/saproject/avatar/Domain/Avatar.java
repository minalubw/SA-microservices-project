package saproject.avatar.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "avatars")
public class Avatar {
    @Id
    private int id;
    private Element head;// round, square, triangle, diamond, heart, star, pentagon, hexagon, octagon, circle, oval
    private Element hair;// bald, short, medium, long, ponytail, afro, mohawk, dreadlocks, curly, straight, wavy, shaved
    private Element eye;// blue, green, brown, hazel, black, red, purple, pink, yellow, orange, grey, white
    private Element eyebrow;// straight, curved, thick, thin, bushy, sparse, arched, straight, round, flat, thin, thick, bushy, sparse
    private Element nose;// round, flat, wide, narrow, long, short, button, upturned, downturned, hooked, flared, wide, narrow, long, short
    private Element mouth;// smile, frown, smirk, grin, grimace, pout, tongue, teeth, lips, tongue, teeth, lips
    private Element ears;// round, pointed, long, short, large, small, round, pointed, long, short, large, small
    private Element body;// Skinny , Average , Muscular , Fat , Skinny , Average , Muscular , Fat
    private Element hat;// BaseballCap , Beanie , Beret , BowlerHat , BucketHat , Fedora , FloppyHat , TopHat , Trilby , BaseballCap , Beanie
    private Element top;// TShirt , TankTop , LongSleeve , Hoodie , TShirt , TankTop , LongSleeve , Hoodie
    private Element topColor;// Red , Orange , Yellow , Green , Blue , Purple , Pink , White , Black , Brown , Grey , Red
    private Element hatColor;// Red , Orange , Yellow , Green , Blue , Purple , Pink , White , Black , Brown , Grey , Red

}


