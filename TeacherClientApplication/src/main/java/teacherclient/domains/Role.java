package teacherclient.domains;

public enum Role {
    ADMIN("ADMIN"), STUDENT("STUDENT"), TEACHER("TEACHER");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}