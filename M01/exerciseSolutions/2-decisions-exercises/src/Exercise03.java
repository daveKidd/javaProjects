import java.util.Scanner;

public class Exercise03 {

    public static void main(String[] args) {
        // 1. Change the code to accept input from the user.
        // Use a Scanner and parse the input with Integer.parseInt.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a whole number: ");
        int value = Integer.parseInt(console.nextLine());

        if (value >= 10 && value < 26) {
            System.out.println("Value is in the acceptable range.");
        }
    }
}