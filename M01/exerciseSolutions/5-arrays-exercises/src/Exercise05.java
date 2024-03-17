public class Exercise05 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's continents.
        // Do not use array literal notation. Allocate space for 7 continents and then set each value by index.
        String[] continents = new String[7];
        continents[0] = "Africa";
        continents[1] = "Antarctica";
        continents[2] = "Asia";
        continents[3] = "Europe";
        continents[4] = "North America";
        continents[5] = "Oceania/Australia";
        continents[6] = "South America";

        // 2. Loop over each element and print it.
        for (int i = 0; i < continents.length; i++) {
            System.out.println(continents[i]);
        }
    }
}
