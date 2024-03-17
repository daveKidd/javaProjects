public class MultiDimArrays {
    public static void main(String[] args) {
        String[][] foods = {
            { "🍖", "🥓", "🥩" },
            { "🍉", "🍍" },
            { "🍨", "🍩", "🥞" }
        };

        // Read from the second "row" and second "column";
        String food = foods[0][2];

        System.out.println(food);            // 🥩
        System.out.println(foods[1][1]); // 🍍

        // Replace the element in the third row, first column.
        foods[2][1] = "🍕";
        System.out.println(foods[2][1]); // 🍕

        System.out.println("Time to loop!");
        for (int row = 0; row < foods.length; row++) { // this loop goes through each individual array
            for (int col = 0; col < foods[row].length; col++) { // this loop goes through each item in the individual arrays
                System.out.println(foods[row][col]);
            }
        }
    }
}
