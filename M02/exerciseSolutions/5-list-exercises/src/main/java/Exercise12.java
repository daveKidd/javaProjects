import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise12 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        Exercise02.printAllBoardGames(games);
        System.out.println();

        // 1. Shift all games two positions to the left. A game at index 0 "shifts" to the end of the list.
        // Example: A,B,C,D,E -> shifted two positions is -> C,D,E,A,B
        // 2. Print `games` and confirm the new order.
        BoardGame firstGame = games.remove(0); // removes the first game
        BoardGame secondGame = games.remove(0); // removes the second game (which is now at index 0)

        games.add(firstGame); // adds the first game to the end of the list
        games.add(secondGame); // adds the second game to the end of the list

        //or
//        games.add(games.remove(0)); // removes the first game and adds it to the end of the list
//        games.add(games.remove(0)); // removes the second game (which is now at index 0) and adds it to the end of the list
        Exercise02.printAllBoardGames(games);
    }
}
