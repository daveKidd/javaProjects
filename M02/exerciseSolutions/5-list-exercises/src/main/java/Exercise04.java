import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise04 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame>.
        // 2. Add three BoardGames to the new list.
        // 3. Print the new list.
        // 4. Add items in the new list to `games` with the `addAll` method.
        // 5. Print `games`.

        ArrayList<BoardGame> newGameList = new ArrayList<>();
        newGameList.add(new BoardGame("Zombicide",2,6,"CO-OP"));
        newGameList.add(new BoardGame("Bang!",2,8,"Card Game"));
        newGameList.add(new BoardGame("Star Realms",2,10,"Deck Builder"));

        Exercise02.printAllBoardGames(newGameList);
        System.out.println();

        games.addAll(newGameList);

        Exercise02.printAllBoardGames(games);
    }
}
