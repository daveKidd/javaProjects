public class Exercise09 {

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        printBox(4,4);
        printBox(5,2);
        printBox(2,3);

    }

    // 1. Create a method.
    // Name: printBox
    // Inputs: int, int
    // Output: void
    // Description: prints a visual box to the console. The first parameter is the number of rows to print.
    // The second parameter is the number of columns.
    // See repetition Exercise15.

    public static void printBox(int rows, int cols){
        System.out.println("Box!");
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    // Expected Output (5 rows, 5 columns)
    // #####
    // #####
    // #####
    // #####
    // #####

    // (3 rows, 4 columns)
    // ####
    // ####
    // ####
}
