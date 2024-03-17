import java.util.Scanner;

public class Exercise11 {
    /*
    1. Add a new class, `Exercise11`, to this project.
    2. Add a `main` method.
    3. Collect three integers from a user: `start`, `end`, and `increment`.
    4. Write a loop to sum values from `start` to `end` counting by the `increment`.
    5. Print the result.
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Start: ");
        int start = Integer.parseInt(console.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(console.nextLine());

        System.out.print("Increment: ");
        int increment = Integer.parseInt(console.nextLine());

        int sum = 0;
        for(int i = start; i <= end; i += increment){
            sum += i;
        }
        System.out.println(sum);
    }
}
