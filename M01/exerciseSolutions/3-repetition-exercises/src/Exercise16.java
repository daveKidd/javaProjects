import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // BORDER BOX
        // 1. Use nested loops to print a box in the console with a different character for the border.
        // One loop should represent rows and the other should represent columns.
        // The border character should be different from the internal box character.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // *****
        // *###*
        // *###*
        // *###*
        // *****

        // (3X4)
        // ****
        // *##*
        // ****

        // (2X2)
        // **
        // **

        Scanner console = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int rows = Integer.parseInt(console.nextLine());

        System.out.print("Number of columns: ");
        int cols = Integer.parseInt(console.nextLine());

        for(int i=0; i < rows; i++){
            if(i == 0){
                System.out.println("!".repeat(cols));
            }else if(i == rows - 1){
                System.out.println("!".repeat(cols));
            }else{
                for(int j=0; j < cols; j++){
                    if(j==0){
                        System.out.print("!");
                    }else if(j==cols-1){
                        System.out.print("!");
                    }else{
                        System.out.print("#");
                    }
                }
                System.out.println(); // ends the current row
            }
        }
    }
}
