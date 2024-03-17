import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        /*emojis
            🍖 🍉 🥓 🥩 🍕 🍤 🍨 🌮 🍩 🥞 🍍
        */
        Scanner console = new Scanner(System.in);
        System.out.print("How many courses will your meal be?: ");
        int numOfCourses = Integer.parseInt(console.nextLine());

        String[] meal = new String[numOfCourses];

        for(int i = 0; i<numOfCourses;i++){
            System.out.printf("Course #%s: ",i+1);
            String course = console.nextLine();
            meal[i] = course;
        }

        System.out.println("Here is your meal!");
        for(int i = 0; i<meal.length;i++){
            System.out.println(meal[i]);
        }
    }
}
