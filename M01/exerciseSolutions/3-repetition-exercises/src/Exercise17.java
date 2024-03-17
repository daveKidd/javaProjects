import java.util.Scanner;

public class Exercise17 {

    public static void main(String[] args) {
        // USER-DEFINED BOX
        // 1. Collect the following from a user: rows, columns, box character, border character.
        // 2. Use nested loops to print a user-defined box in the console.
        // (See Exercise16.)

        Scanner console = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int rows = Integer.parseInt(console.nextLine());

        System.out.print("Number of columns: ");
        int cols = Integer.parseInt(console.nextLine());

        System.out.print("Box character: ");
        String boxChar = console.nextLine();

        System.out.print("Border character: ");
        String borderChar = console.nextLine();

        for(int i=0; i < rows; i++){
            if(i == 0){
                System.out.println(borderChar.repeat(cols));
            }else if(i == rows - 1){
                System.out.println(borderChar.repeat(cols));
            }else{
                for(int j=0; j < cols; j++){
                    if(j==0){
                        System.out.print(borderChar);
                    }else if(j==cols-1){
                        System.out.print(borderChar);
                    }else{
                        System.out.print(boxChar);
                    }
                }
                System.out.println();
            }
        }
    }
}
