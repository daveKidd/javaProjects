import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // BOX
        // 1. Use nested loops to print a box in the console.
        // One loop should represent rows and the other should represent columns.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // #####
        // #####
        // #####
        // #####
        // #####

        // (3X4)
        // ####
        // ####
        // ####

        Scanner console = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int rows = Integer.parseInt(console.nextLine());

        System.out.print("Number of columns: ");
        int cols = Integer.parseInt(console.nextLine());

        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
