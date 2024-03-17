import learn.BoardGame;
import learn.GameRepository;

import java.util.ArrayList;

public class Exercise10 {

    public static void main(String[] args) {

        ArrayList<BoardGame> games = GameRepository.getAll();
        Exercise02.printAllBoardGames(games);
        System.out.println();

        // 1. Loop over `games` and remove any game that can be played by one person.
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getMinPlayers() == 1){
                games.remove(i);
            }
        }
        // 2. Print `games` and confirm single-player games are removed.
        Exercise02.printAllBoardGames(games);
    }
}
