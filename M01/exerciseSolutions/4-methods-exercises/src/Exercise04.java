public class Exercise04 {

    public static void main(String[] args) {
        System.out.println(getFirstVowel("magnificent")); // Expected: a
        System.out.println(getFirstVowel("winsome")); // Expected: i
        System.out.println(getFirstVowel("xxx")); // Expected:

        // 2. Call getFirstVowel at least one more time.
        System.out.println(getFirstVowel("incredible"));
    }

    // getFirstVowel returns the first vowel in a string as a char.
    // 1. Complete getFirstVowel.
    // If no vowel is found, return 0. (As a char, 0 represents the NULL value.)
    public static char getFirstVowel(String value) {
        if(value == null){
            return 0;
        }

        for(int i = 0; i < value.length(); i++){
            char c = Character.toLowerCase(value.charAt(i));
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                return c;
            }
        }
        return 0;
    }
}
