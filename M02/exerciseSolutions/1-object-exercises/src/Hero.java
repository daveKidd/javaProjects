public class Hero {
    /*
    1. Add a class to the project named `Hero`. It represents a super hero.
    2. Add two fields:
        - `String name`
        - `Power[] powers`
    3. Add a constructor that accepts a `String` and `Power[]` and sets the appropriate field.
    4. Add getters for both the `name` and `powers` fields.
    */

    private String name;
    private Power[] powers;

    public Hero(String name, Power[] powers) {
        this.name = name;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Power[] getPowers() {
        return powers;
    }

    public void setPowers(Power[] powers) {
        this.powers = powers;
    }

    // 1. Create a new method in the Hero class.
    // Name: toLine
    // Inputs: none
    // Output: String
    // Description: returns the Hero's name and powers as a single line of text.

    public String toLine(){
// option #1: manually concatening string values from an array
//        Power[] powers = getPowers();
//        String powersDisplay = "";
//        for (int i = 0; i < powers.length; i++) {
//            powersDisplay += (i == 0 ? "" : ", ") + powers[i].getName();
//        }

        // option #2: "mapping" Power.getName() to a string array
        Power[] powers = getPowers();
        String[] powerNames = new String[powers.length];
        for (int i = 0; i < powers.length; i++) {
            powerNames[i] = powers[i].getName();
        }

        return String.format("%s (%s)", getName(), String.join(", ", powerNames));

//        return String.format("%s (%s)", getName(), Arrays.asList(getPowers()));
    }
}
