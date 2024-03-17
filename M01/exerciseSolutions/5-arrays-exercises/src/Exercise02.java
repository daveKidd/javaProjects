public class Exercise02 {

    public static void main(String[] args) {

        String[] tenFavoriteFoods = new String[10]; // space for 10 favorite foods

        tenFavoriteFoods[5] = "squid ink";
        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[6]);

        // 1. Set your 10 favorite foods. (It's okay to replace squid ink.)
        tenFavoriteFoods[0] = "risotto";
        tenFavoriteFoods[1] = "blueberries";
        tenFavoriteFoods[2] = "late summer tomatoes";
        tenFavoriteFoods[3] = "arugula";
        tenFavoriteFoods[4] = "really good parmesan cheese";
        tenFavoriteFoods[5] = "balsamic vinegar";
        tenFavoriteFoods[6] = "french fries";
        tenFavoriteFoods[7] = "oatmeal with bananas and frozen fruit";
        tenFavoriteFoods[8] = "sushi";
        tenFavoriteFoods[9] = "crusty bread";

        // 2. Print your top, 6th, and last favorite from tenFavoriteFoods.
        System.out.println(tenFavoriteFoods[0]);
        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[9]);
    }
}
