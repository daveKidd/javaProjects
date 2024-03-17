public class Balloon {
    /*
    1. Add a class to this project named `Balloon`.
    2. Add two private fields:
        - `String color`: balloon's color
        - `double psi`: balloon's pressure in lbs/sq inch
    3. Add a constructor that accepts a `String` color and sets the field. Do not set psi.
    4. Add getters for both color and psi. (psi will always have its default value 0.0)
     */

    private String color;
    private double psi;

    public Balloon(String color) {
        this.color = color;
        this.psi = 0;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 2. Edit the getPsi method.
    // If the psi field is greater than 16.0, return Double.POSITIVE_INFINITY.
    // Otherwise, return psi.

    public double getPsi() {
        if(this.psi > 16.0){
            return Double.POSITIVE_INFINITY;
        }else{
            return psi;
        }
    }

    public void setPsi(double psi) {
        this.psi = psi;
    }

    // 1. Create a new method in the Balloon class.
    // Name: inflate
    // Inputs: none
    // Output: void
    // Description: adds a random value to the psi field between 0.0 and 5.0
    // this.psi = this.psi + Math.random() * 5.0;

    public void inflate(){
        this.psi = this.psi + Math.random() * 5.0;
    }

    // 1. Create a new method in the Balloon class.
    // Name: isExploded
    // Inputs: none
    // Output: boolean
    // Description: if the psi field is greater than 16.0, returns true.
    // Otherwise, returns false.

    public boolean isExploded(){

        boolean exploded = this.psi > 16.0 ? true : false;
        return exploded;

//        if(this.psi > 16.0){
//            return true;
//        }else{
//            return false;
//        }
    }
}
