import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise11 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        Exercise02.printAllBoardGames(games);
        System.out.println();

        // 1. Swap the 2nd game with the 4th and the 3rd with the 7th.
        Collections.swap(games,1,3);
        Collections.swap(games, 2,6);

        // 2. Print `games` and confirm their order.
        Exercise02.printAllBoardGames(games);
    }
}
