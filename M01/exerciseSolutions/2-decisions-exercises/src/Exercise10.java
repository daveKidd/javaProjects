import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // USPS
        // Below is an abbreviated version of the US Postal Service retail parcel rates:
        /*
        Lbs | Zones 1&2 | Zone 3
        ===============
        1      $7.50      $7.85
        2       8.25       8.70
        3       8.70       9.70
        4       9.20      10.55
        5      10.20      11.30
        */

        // 1. Collect the parcel lbs and zone (1, 2, or 3) from the user.
        // 2. Add `if`/`else if`/`else` logic to cover all rates.
        // Use whatever strategy you think is best. You can create compound conditions or nest if/else statements.
        // If a lbs/zone combo does not exist, print a warning message for the user.

        Scanner console = new Scanner(System.in);

        System.out.print("Pounds: ");
        int lbs = Integer.parseInt(console.nextLine());

        System.out.print("Zone: ");
        int zone = Integer.parseInt(console.nextLine());

        if(lbs == 1 && (zone == 1 || zone == 2)){
            System.out.println("Rate: $7.50");
        }else if(lbs == 1 && zone == 3){
            System.out.println("Rate: $7.85");
        }
        else if(lbs == 2 && (zone == 1 || zone == 2)){
            System.out.println("Rate: $8.25");
        }else if(lbs == 2 && zone == 3) {
            System.out.println("Rate: $8.70");
        }
        else if(lbs == 3 && (zone == 1 || zone == 2)){
            System.out.println("Rate: $8.70");
        }else if(lbs == 3 && zone == 3) {
            System.out.println("Rate: $9.70");
        }
        else if(lbs == 4 && (zone == 1 || zone == 2)){
            System.out.println("Rate: $9.20");
        }else if(lbs == 4 && zone == 3) {
            System.out.println("Rate: $10.55");
        }
        else if(lbs == 5 && (zone == 1 || zone == 2)){
            System.out.println("Rate: $10.20");
        }else if(lbs == 5 && zone == 3) {
            System.out.println("Rate: $11.30");
        }
        else{
            System.out.println("Pounds must be between 1-5 and Zone must be 1, 2, or 3");
        }
    }
}
