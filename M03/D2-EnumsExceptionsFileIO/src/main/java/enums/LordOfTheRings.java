package enums;

public enum LordOfTheRings {
    FRODO_BAGGINS(50),
    LEGOLAS(100),
    GANDALF(300),
    GOLLUM(2);

    private int attack;

    LordOfTheRings(int value){
        this.attack = value;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
