import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        printHeader("Calculator of TV Capaciousness");

        String tvBrand = promptForWord("TV Brand: ", console);

        int unitSelection = getUnitSelection(console);

        double calculatedTvSize = getCalculatedTvSize(console, unitSelection);

        printHeader("The reveal is near....");
        printTvSize(tvBrand, calculatedTvSize);

    }

    private static void printTvSize(String tvBrand, double calculatedTvSize) {
        DecimalFormat df = new DecimalFormat("0.#");
        String tvSize = df.format(calculatedTvSize);
        System.out.printf("Your %s TV will need to be %s inches", tvBrand,tvSize);
    }

    private static double getCalculatedTvSize(Scanner console, int unitSelection) {
        double calculatedTvSize = 0;
        switch(unitSelection){
            case 1:
                System.out.println("Great!  How many inches is your couch from the wall?");
                double inches = Double.parseDouble(console.nextLine());
                calculatedTvSize = Math.ceil(inches/2.5);
                break;
            case 2:
                System.out.println("Great!  How many feet is your couch from the wall?");
                double feet = Double.parseDouble(console.nextLine());
                calculatedTvSize = Math.ceil(feet/.2083);
                break;
            case 3:
                System.out.println("Great!  How many yards is your couch from the wall?");
                double yards = Double.parseDouble(console.nextLine());
                calculatedTvSize = Math.ceil(yards/.0694);
                break;
        }
        return calculatedTvSize;
    }

    private static int getUnitSelection(Scanner console) {
        boolean keepGoing = true;
        int unitSelection = 0;
        while(keepGoing) {
            System.out.println("Thanks! Now we need the distance from your couch to the wall");
            System.out.println("Which unit of length do you want to use?");
            System.out.println("1 - Inches");
            System.out.println("2 - Feet");
            System.out.println("3 - Yards");
            unitSelection = Integer.parseInt(console.nextLine());
            if(unitSelection == 1 || unitSelection == 2 || unitSelection == 3){
                keepGoing = false;
            }else{
                System.out.println("Invalid choice please try again");
            }
        }
        return unitSelection;
    }

    public static void printHeader(String message){
        System.out.println(message);
        System.out.println("-".repeat(message.length()));
    }

    public static String promptForWord(String prompt, Scanner console){
        System.out.println();
        System.out.println(prompt);
        String word = console.nextLine();
        return word;
    }
}
