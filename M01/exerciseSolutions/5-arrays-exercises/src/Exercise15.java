import java.util.Random;

public class Exercise15 {

    public static void main(String[] args) {
        int[] one = makeRandomArray();
        int[] two = makeRandomArray();

        // 1. Create a new int[] with room enough for all elements in `one` and `two`.
        int[] result = new int[one.length + two.length];

        // 2. Copy elements from `one` into the beginning of the array.
        int resultIndex = 0;
        for (int i = 0; i < one.length; i++) {
            result[resultIndex] = one[i];
            resultIndex++;
        }

        // 3. Copy elements from `two` at the end of the array.
        for (int i = 0; i < two.length; i++) {
            result[resultIndex] = two[i];
            resultIndex++;
        }

        // 4. Print the results to confirm that it worked.
        System.out.println("array one is length " + one.length);
        System.out.println("array two is length " + two.length);
        System.out.println("result array is length " + result.length);
        System.out.println("Results: ");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%s: %s%n", i, result[i]);
        }
    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
