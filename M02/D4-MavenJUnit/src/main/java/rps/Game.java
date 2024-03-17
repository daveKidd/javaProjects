package rps;

import rps.players.Player;

public class Game {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;

    private final Player playerOne;
    private final Player playerTwo;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public int playRound(){
        int p1Shot = playerOne.shoot();
        int p2Shot = playerTwo.shoot();

        if(p1Shot == p2Shot){
            return 0; // tie
        }else if((p1Shot == ROCK && p2Shot == SCISSORS) ||
                (p1Shot == PAPER && p2Shot == ROCK) ||
                (p1Shot == SCISSORS && p2Shot == PAPER)){
            return 1;
        }
        return 2;
    }
}
