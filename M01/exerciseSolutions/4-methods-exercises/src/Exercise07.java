public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static boolean areInOrder(int num1, int num2, int num3, int num4){
        return num1 <= num2 && num2 <= num3 && num3 <= num4;
    }

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        System.out.println(areInOrder(1,2,3,4));
        System.out.println(areInOrder(1,3,2,4));
        System.out.println(areInOrder(12,22,32,42));
        System.out.println(areInOrder(-12,-22,32,42));
    }
}
