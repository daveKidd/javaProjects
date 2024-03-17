import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise02 {

    // 1. Create a method to print all BoardGames in an ArrayList<BoardGame>.
    // Consider making it `public` so you can use it in other exercises.

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 2. Print `games` using your "print all" method.
        printAllBoardGames(games);
    }

    public static void printAllBoardGames(ArrayList<BoardGame> allGames){
        for(BoardGame game : allGames){
            System.out.println(game);
        }
    }
}
