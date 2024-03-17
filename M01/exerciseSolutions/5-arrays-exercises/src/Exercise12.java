import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        // 1. Count the number of positive and non-positive elements in `values`.
        int positiveCount = 0;
        int nonPositiveCount = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                positiveCount++;
            } else {
                nonPositiveCount++;
            }
        }

        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        // (We count first to determine the capacity to allocate.)
        int[] positives = new int[positiveCount];
        int[] nonPositives = new int[nonPositiveCount];


        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        // If it is non-positive, add it to the non-positive array.
        positiveCount = 0;
        nonPositiveCount = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                positives[positiveCount] = values[i];
                positiveCount++;
            } else {
                nonPositives[nonPositiveCount] = values[i];
                nonPositiveCount++;
            }
        }

        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.
        System.out.println("Positive values:");
        for (int i = 0; i < positives.length; i++) {
            System.out.println(positives[i]);
        }

        System.out.println("\nNon-positive values:");
        for (int i = 0; i < nonPositives.length; i++) {
            System.out.println(nonPositives[i]);
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
