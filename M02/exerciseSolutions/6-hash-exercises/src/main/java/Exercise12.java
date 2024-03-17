import java.util.HashSet;
import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        Random random = new Random();
        HashSet<Integer> numbers = new HashSet<>();

        // 1. Generate 10 unique random numbers between 0 and 100.
        for(int i = 0; i < 1000; i++){
            int randomNum = random.nextInt(100);
            numbers.add(randomNum);
            if(numbers.size() == 10){
                break;
            }
        }
        // 2. Print the numbers to the console.
        // (Hint: You can add random numbers to the `numbers` HashSet until its size is 10.
        // That guarantees the numbers are unique.)
        for (int number : numbers) {
            System.out.println(number);
        }

    }
}
