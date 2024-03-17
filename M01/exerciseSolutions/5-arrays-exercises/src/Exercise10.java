import java.util.Arrays;
import java.util.Random;

public class Exercise10 {

    public static void main(String[] args) {
        String[] bugs = makeBugArray();

        // The bugs array elements are either the value "beetle" or "mosquito".
        // 1. Count the number of beetles and mosquitoes.
        int beetles = 0;
        int mosquitos = 0;
        for (int i = 0; i < bugs.length; i++) {
            // defensive null check
            if (bugs[i] != null) {
                if (bugs[i].equals("beetle")) {
                    beetles++;
                } else if (bugs[i].equals("mosquito")) {
                    mosquitos++;
                }
            }
        }
        // 2. Print the result.
        // Results will vary because of randomness.
        System.out.println("Beetles: " + beetles);
        System.out.println("Mosquitos: " + mosquitos);
    }

    public static String[] makeBugArray() {
        String[] bugs = new String[200];
        Arrays.fill(bugs, "beetle"); // fills the whole bugs array with "beetle" strings
        Random random = new Random();
        for (int i = 0; i < random.nextInt(150); i++) {
            bugs[random.nextInt(bugs.length)] = "mosquito";
        }
        return bugs;
    }
}
