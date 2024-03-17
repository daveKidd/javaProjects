public class App {
    public static void main(String[] args) {
        /*emojis
            🍖 🍉 🥓 🥩 🍕 🍤 🍨 🌮 🍩 🥞 🍍
        */

        String[] meal2 = {
            "🍖",
            "🍉",
            null,
            "🥩",
            null
        };
        meal2[2] = "🍤";
        meal2[4] = "🌮";
        System.out.println("Here is 2nd breakfast:");

        // last two?
        for(int i = meal2.length - 2; i < meal2.length; i++){
            if(meal2[i] != null){
                System.out.println(meal2[i]);
            }
        }

        // first two items
//        for(int i = 0; i < 2; i++){
//            if(meal2[i] != null){
//                System.out.println(meal2[i]);
//            }
//        }


//        for(int i = 0; i < meal2.length; i++){
//            if(meal2[i] != null){
//                System.out.println(meal2[i]);
//            }
//        }



//        System.out.println(meal2[0]);
//        meal2[1] = "hi";
//        System.out.println(meal2[1]);

//        int[] arrayInt = new int[5];
//        for(int i = 0; i < arrayInt.length; i++){
//            System.out.println(arrayInt[i]);
//        }

//        String[] meal = new String[3];
//        meal[0] = "🍨";
//        meal[1] = "🥩";
//        meal[2] = "🥞";
//
//        System.out.println("Here is your meal:");
//        for(int i = 0; i < meal.length; i++){
//            System.out.println(meal[i]);
//        }
//        System.out.println("\uD83C\uDF56ԅ(´ڡ`ԅ)  \uD83C\uDF56ԅ( ͒ \u06DD ͒ )  (っˆڡˆς)");


//        String[] food = new String[3];
//        food[0] = "🍩";
//        System.out.println(food[1]);
//        System.out.println(food[0]);
//        food[2] = "🥓";
//        food[3] = "🌮";
    }
}
