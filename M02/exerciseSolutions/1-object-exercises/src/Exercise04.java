import java.util.Scanner;

public class Exercise04 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // 1. Add an empty constructor to Musician.
        // 2. Uncomment the code below and make sure it runs.

        Musician m = new Musician();
        System.out.print("Musician name:");
        m.setName(console.nextLine());
        System.out.print("Musician rating:");
        int rating = Integer.parseInt(console.nextLine());
        m.setRating(rating);
        System.out.printf("%s: %s%n", m.getName(), m.getRating());

        // 3. Add a loop. The exercise should ask the user for musicians and print
        // them out until the user types "end".

        boolean appState = true;

        do{
            Musician musician = new Musician();
            System.out.print("Musician name: ");
            musician.setName(console.nextLine());
            System.out.print("Musician rating: ");
            int musicianRating = Integer.parseInt(console.nextLine());
            musician.setRating(musicianRating);
            System.out.printf("%s: %s%n%n", musician.getName(), musician.getRating());
            System.out.println("Type \"end\" to finish or press enter to keep going");
            if(console.nextLine().equalsIgnoreCase("end")){
                System.out.println("Buh Bye!");
                appState = false;
            }
        }while(appState);
    }
}
