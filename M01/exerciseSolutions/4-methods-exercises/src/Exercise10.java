public class Exercise10 {
    public static void main(String[] args) {
        System.out.println(removeWhiteSpace("What is up people?"));
        System.out.println(removeWhiteSpace("Not much you?"));
    }
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.

    public static String removeWhiteSpace(String phrase){
        String result = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (!Character.isWhitespace(phrase.charAt(i))) {
                result += phrase.charAt(i);
            }
        }
        return result;
    }
}
