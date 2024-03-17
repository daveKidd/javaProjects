package exceptions;

import enums.LordOfTheRings;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println(LordOfTheRings.GANDALF);
        System.out.println(LordOfTheRings.GANDALF == LordOfTheRings.GANDALF);
        System.out.println(LordOfTheRings.GANDALF == LordOfTheRings.LEGOLAS);
        System.out.println(LordOfTheRings.GOLLUM.getAttack());
        LordOfTheRings.GOLLUM.setAttack(1000);
        System.out.println(LordOfTheRings.GOLLUM.getAttack());
        //System.out.println(LordOfTheRings.GOLLUM.ordinal());

        LordOfTheRings character = LordOfTheRings.LEGOLAS;

        switch(character){
            case GANDALF:
                System.out.println("You shall not pass!");
                break;
            case GOLLUM:
                System.out.println("My precious!");
                break;
        }

        // Exceptions
//        try{
//            int answer = askForNumber("What is the meaning of life?");
//        }catch(Exception exception){
//            //System.out.println("I'm sorry Dave I'm afraid I can't do that");
//
//        }
    }

    private static int askForNumber(String prompt) throws NumberFormatException {
        Scanner console = new Scanner(System.in);
        int answer = 0;
        boolean isSuccess = false;

        do{
            try{
                System.out.println(prompt);
                answer = Integer.parseInt(console.nextLine());
                if(answer == 42){
                    System.out.println("42 is the meaning of life, goodbye!");
                    isSuccess = true;
                }else{
                    System.out.println("That number is not correct ):");
                }
            }catch(NumberFormatException ex){
                System.out.println("Please provide a number");
            }finally{
                // closing out connections to databases/files/ etc
                System.out.println("I run no matter what bwahahahahahhaha!");
            }
        }while(!isSuccess);

        return answer;
    }
}
