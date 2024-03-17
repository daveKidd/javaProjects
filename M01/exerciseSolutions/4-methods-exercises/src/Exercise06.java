public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static boolean isBetween(int val, int min, int max){
        return val >= min && val <= max;
    }

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(isBetween(1,0,3));
        System.out.println(isBetween(1,4,6));
        System.out.println(isBetween(12,2,32));
    }
}
