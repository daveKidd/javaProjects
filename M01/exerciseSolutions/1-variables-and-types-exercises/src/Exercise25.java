public class Exercise25 {

    // Mad Libs: https://en.wikipedia.org/wiki/Mad_Libs
    // 1. Add a main method.
    // 2. Declare several variables of various types to be "plugged in" to a Mad Libs sentence.
    // 3. Use string concatenation to build a silly sentence.
    // 4. Print the result.
    // 5. Change variable values to change the sentence. Ask a friend for random values to increase the chances
    // of something hilarious or kinda naughty.

    public static void main(String[] args) {
        String noun = "Dog";
        int age = 44;
        boolean likesSomething = true;
        String verb = "eat";

        String madLib = "The " + noun + " is " + age + " years old and when someone says they " + verb + " a car, they say it's " + likesSomething;
        System.out.println(madLib);
    }
}
