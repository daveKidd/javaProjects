public class Exercise09 {

    public static void main(String[] args) {
        String[] haystack = makeHaystack();

        // A needle is randomly placed in a haystack array with a capacity of 100.
        // 1. Loop through the haystack and find the needle.
        // 2. Print the index where you found it.
        // Hint: this is an exercise about the default value of strings.

        for (int i = 0; i < haystack.length; i++) {
            // first ensure the String is not null
            if (haystack[i] != null && haystack[i].equals("needle")) {
                System.out.println("the needle is at index " + i);
            }
        }
    }

    public static String[] makeHaystack() {
        String[] haystack = new String[100];
        int index = (int) (Math.random() * haystack.length);
        haystack[index] = "needle";
        return haystack;
    }
}
