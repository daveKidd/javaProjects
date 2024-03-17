import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise07 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();

        // 1. Instantiate a new ArrayList<BoardGame> and call it `economicGames`.
        ArrayList<BoardGame> economicGames = new ArrayList<>();

        // 2. Loop over `games`. Add each game with the "Economic" category to `economicGames`.
        for(BoardGame game : games){
            if(game.getCategory().equals("Economic")){
                economicGames.add(game);
            }
        }
        // 3. Print `economicGames`.
        Exercise02.printAllBoardGames(economicGames);
    }
}
