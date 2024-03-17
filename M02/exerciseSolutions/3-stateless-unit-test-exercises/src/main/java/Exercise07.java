public class Exercise07 {

    // 1. Read the reverse JavaDocs.
    // 2. Implement reverse.
    // 3. Create tests for reverse and confirm that it is correct.

    /**
     * Reverses the order of elements in an array argument and returns them in a new array.
     * It does not alter the existing array.
     *
     * @param values the array to reverse
     * @return a new array with elements in reverse order.
     */
    public String[] reverse(String[] values) {
        String[] reversedArray = new String[values.length];
        int reversedArrayIndex = 0;
        for(int i = values.length-1; i >= 0; i--){
            reversedArray[reversedArrayIndex] = values[i];
            reversedArrayIndex++;
        }
        return reversedArray;
    }
}
