package inheritance;

public class Jedi extends Person {
    private String saberColor;
    private String master;

    public Jedi(String name, int age, String saberColor, String master) {
        super(name, age);
        this.saberColor = saberColor;
        this.master = master;
    }

    @Override
    public String speak(String message){
        return String.format("%s puts away their lightsaber and says: %s", getName(), message);
    }

    public void mindTrick(Person person){
        System.out.printf("Using %s's teachings%n%s waves hand and gives a command%n%s obeys"
        ,master,this.getName(),person.getName());
    }

    public String getSaberColor() {
        return saberColor;
    }

    public void setSaberColor(String saberColor) {
        this.saberColor = saberColor;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
