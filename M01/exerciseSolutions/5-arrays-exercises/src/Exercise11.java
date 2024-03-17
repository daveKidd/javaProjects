import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        // 1. Count the number of positive elements in `values`.
        int positiveCount = 0;
        for (int i = 0; i < values.length; i++) {
            // no need to worry about null because ints can't be null
            if (values[i] > 0) {
                positiveCount++;
            }
        }
        // 2. Create a new int[] to hold the positive elements.
        // (We must count first to know the capacity to allocate.)
        int[] positives = new int[positiveCount];


        // 3. Loop through `values` a second time. Add positive elements to the new array.
        positiveCount = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                positives[positiveCount] = values[i];
                positiveCount++;
            }
        }

        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.
        System.out.println("Positive values:");
        for (int i = 0; i < positives.length; i++) {
            System.out.println(positives[i]);
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
