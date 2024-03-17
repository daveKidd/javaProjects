public class Exercise07 {

    public static void main(String[] args) {
        // 1. Calculate the number of offices in a 23 story building
        // where each floor has 15 "rows" and 8 "columns" of offices.
        // 2. Use whatever approach you think is best.
        // 3. Print the result.

        int totalStories = 23;
        int floorOfficeTotal = 15 * 8;
        int totalOffices = totalStories * floorOfficeTotal;

        System.out.println("The number of offices in this buildling is " + totalOffices);
    }
}
