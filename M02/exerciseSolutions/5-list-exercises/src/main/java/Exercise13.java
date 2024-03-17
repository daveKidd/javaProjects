import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise13 {

    private ArrayList<BoardGame> games = GameRepository.getAll();
    private Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        Exercise13 instance = new Exercise13();
        instance.run();
    }

    private void printHeader(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println("=".repeat(message.length()));
    }

    private void run() {

        printHeader("Welcome to the Board Game Manager.");

        String input;
        do {
            printHeader("Menu");
            System.out.println("1. Add a board game.");
            System.out.println("2. Display all board games.");
            System.out.println("3. Remove a board game.");
            System.out.println("4. Exit");
            System.out.print("Select [1-4]: ");
            input = console.nextLine();

            switch (input) {
                case "1":
                    // 1. Create a method that gathers user input via `console` to instantiate a BoardGame
                    // and then adds it to the `games` list.
                    // 2. Replace the the line of code below with a call to the method.
                    addBoardGame();
                    break;
                case "2":
                    // 3. Create a method to display all board games in the `games` list.
                    // 4. Replace the the line of code below with a call to the method.
                    displayAllBoardGames();
                    break;
                case "3":
                    // 5. Stretch Goal: Create a method that allows the user to remove a board game from the
                    // `games` list with an index.
                    // 6. Replace the line of code below with a call to the method.
                    removeBoardGame();
                    break;
                case "4":
                    printHeader("Goodbye.");
                    break;
                default:
                    System.out.printf("%nI don't understand '%s'.%n", input);
                    break;
            }
        } while (!input.equals("4"));
    }

    private void addBoardGame() {
        printHeader("Add Board Game");
        System.out.print("Title: ");
        String title = console.nextLine();

        System.out.print("Min Players: ");
        int minPlayers = Integer.parseInt(console.nextLine());

        System.out.print("Max Players: ");
        int maxPlayers = Integer.parseInt(console.nextLine());

        System.out.print("Category: ");
        String category = console.nextLine();

        games.add(new BoardGame(title,minPlayers,maxPlayers,category));

        System.out.println("\nBoard Game Added!");
    }

    private void displayAllBoardGames() {
        printHeader("All Board Games");
        for(BoardGame game : games){
            System.out.println(game);
        }
    }

    private void removeBoardGame() {
        printHeader("Remove Board Game");
        System.out.print("Enter index of game to be removed: ");
        int index = Integer.parseInt(console.nextLine());

        games.remove(index);
        System.out.println("\nGame index # " + index + " removed");
    }
}
