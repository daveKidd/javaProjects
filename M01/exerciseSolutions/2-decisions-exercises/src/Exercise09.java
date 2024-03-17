import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        /*
        1. Add a class, `Exercise09`, to this project.
        2. Add a `main` method.
        3. Declare a `Scanner` variable.
        4. Collect three pieces of data from the user: a minimum value, a maximum value, and an actual value.
        5. Add `if/else` statements to determine if the actual value is between the min and max.
        6. Print messages for both true and false cases.
         */
        Scanner console = new Scanner(System.in);

        System.out.print("Minimum value: ");
        int min = Integer.parseInt(console.nextLine());

        System.out.print("Maximum value: ");
        int max = Integer.parseInt(console.nextLine());

        System.out.print("Actual value: ");
        int actual = Integer.parseInt(console.nextLine());

        if(actual >= min && actual <= max){
            System.out.println("The actual value is between the min and max");
        }else{
            System.out.println("The actual value is not between the min and max");
        }
    }
}
