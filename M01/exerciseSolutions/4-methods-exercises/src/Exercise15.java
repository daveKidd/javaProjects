import java.util.Scanner;

public class Exercise15 {
    /* FIZZ BUZZ

    Historically, the Fizz Buzz (https://en.wikipedia.org/wiki/Fizz_buzz) problem was used in programming interviews.
    Not sure if it still is. Just in case, we'll get it out of the way in Milestone 1.

    Write a program to:
    - Prompt a user for a positive integer and store the result. (Could reuse a readInt method.)
    - Loop from the number 1 to the user's integer.
    - If the number is divisible by 3, print Fizz.
    - If the number is divisible by 5, print Buzz.
    - If the number is divisible by both 3 and 5, print Fizz Buzz.
    - If the number is not divisible by either 3 or 5, print the number.

    Example Output:
    1
    2
    Fizz
    4
    Buzz
    Fizz
    7
    8
    Fizz
    Buzz
    11
    Fizz
    13
    14
    Fizz Buzz
    16
    17
    Fizz
     */

    public static void main(String[] args) {

        System.out.println("Welcome to Fizz/Buzz.");
        int number = readPositiveInt("Enter a positive integer: ");
        System.out.println("\nHere are your Fizz/Buzz results:");

        for (int i = 1; i <= number; i++) {
            String line = null;
            if (i % 3 == 0) {
                line = "Fizz";
            }
            if (i % 5 == 0) {
                if (line == null) {
                    line = "Buzz";
                } else {
                    line += " Buzz";
                }
            }
            if (line == null) {
                System.out.println(i);
            } else {
                System.out.println(line);
            }
        }
    }

    public static String readRequiredString(String prompt) {
        Scanner console = new Scanner(System.in);
        String result;
        do {
            System.out.print(prompt);
            result = console.nextLine();
            if (result.isBlank()) {
                System.out.println("ERR: value cannot be empty or blank.");
            }
        } while (result.isBlank());
        return result;
    }

    public static int readPositiveInt(String prompt) {
        int result;
        do {
            String input = readRequiredString(prompt);
            result = Integer.parseInt(input);
            if (result <= 0) {
                System.out.println("ERR: must be a positive number.");
            }
        } while (result <= 0);
        return result;
    }
}
