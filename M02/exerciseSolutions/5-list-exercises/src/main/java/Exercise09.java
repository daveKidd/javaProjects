import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise09 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        Exercise02.printAllBoardGames(games);
        System.out.println();

        // 1. Grab the 8th game in `games`.
        BoardGame game8 = games.get(7);
        // 2. Remove it passing its reference to the `remove` method.
        ArrayList<BoardGame> oneLessGame = remove(game8, games);
        // 3. Print `games` and confirm it's gone.
        Exercise02.printAllBoardGames(oneLessGame);
    }

    public static ArrayList<BoardGame> remove(BoardGame game, ArrayList<BoardGame> games){
        for(int i = 0; i < games.size(); i++){
            if(games.get(i) == game){
                games.remove(i);
            }
        }
        return games;
    }
}
