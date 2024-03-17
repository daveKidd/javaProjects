import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise03 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        Exercise02.printAllBoardGames(games);
        System.out.println();

        // 1. Add three new games to `games` with the `add` method.
        // 2. Print `games` after each add.
        Exercise02.printAllBoardGames(games);

        games.add(new BoardGame("Zombicide",2,6,"CO-OP"));
        Exercise02.printAllBoardGames(games);
        System.out.println();

        games.add(new BoardGame("Bang!",2,8,"Card Game"));
        Exercise02.printAllBoardGames(games);
        System.out.println();

        games.add(new BoardGame("Star Realms",2,10,"Deck Builder"));
        Exercise02.printAllBoardGames(games);



    }
}
