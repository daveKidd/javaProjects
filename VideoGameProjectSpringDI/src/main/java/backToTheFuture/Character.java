package backToTheFuture;

public class Character {
    private final String name;
    private int version;

    public Character(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
