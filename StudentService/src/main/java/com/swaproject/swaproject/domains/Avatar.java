package com.swaproject.swaproject.domains;

import jakarta.persistence.Id;

public class Avatar {
    @Id
    private int id;
    private String head;// round, square, triangle, diamond, heart, star, pentagon, hexagon, octagon, circle, oval
    private String hair;// bald, short, medium, long, ponytail, afro, mohawk, dreadlocks, curly, straight, wavy, shaved
    private String eye;// blue, green, brown, hazel, black, red, purple, pink, yellow, orange, grey, white
    private String eyebrow;// straight, curved, thick, thin, bushy, sparse, arched, straight, round, flat, thin, thick, bushy, sparse
    private String nose;// round, flat, wide, narrow, long, short, button, upturned, downturned, hooked, flared, wide, narrow, long, short
    private String mouth;// smile, frown, smirk, grin, grimace, pout, tongue, teeth, lips, tongue, teeth, lips
    private String ears;// round, pointed, long, short, large, small, round, pointed, long, short, large, small
    private String body;// Skinny , Average , Muscular , Fat , Skinny , Average , Muscular , Fat
    private String hat;// BaseballCap , Beanie , Beret , BowlerHat , BucketHat , Fedora , FloppyHat , TopHat , Trilby , BaseballCap , Beanie
    private String top;// TShirt , TankTop , LongSleeve , Hoodie , TShirt , TankTop , LongSleeve , Hoodie
    private String topColor;// Red , Orange , Yellow , Green , Blue , Purple , Pink , White , Black , Brown , Grey , Red
    private String hatColor;// Red , Orange , Yellow , Green , Blue , Purple , Pink , White , Black , Brown , Grey , Red
}