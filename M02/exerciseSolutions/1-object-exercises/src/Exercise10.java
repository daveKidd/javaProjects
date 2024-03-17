import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // BALLOON GAME
        Scanner console = new Scanner(System.in);

        // 1. Instantiate three balloons of different colors.
        Balloon b1 = new Balloon("green");
        Balloon b2 = new Balloon("blue");
        Balloon b3 = new Balloon("red");

        boolean keepGoing = true;
        do {
            System.out.println("Inflate? [y/n]: ");
            if (console.nextLine().equalsIgnoreCase("y")) {
                // 2. If the user confirms an inflate, inflate each balloon.
                b1.inflate();
                b2.inflate();
                b3.inflate();
            }

            // 3. When one or more balloons explode, stop the loop.
            if(b1.isExploded() || b2.isExploded() || b3.isExploded()){
                keepGoing = false;
            }
        } while (keepGoing);

        // 4. Print the color of the winners (balloons that exploded).
        if(b1.isExploded()){
            System.out.println(b1.getColor());
        }
        if(b2.isExploded()){
            System.out.println(b2.getColor());
        }
        if(b3.isExploded()){
            System.out.println(b3.getColor());
        }
    }
}
