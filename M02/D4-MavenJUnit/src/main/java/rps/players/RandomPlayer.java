package rps.players;

import java.util.Random;

public class RandomPlayer implements Player {

    private Random random = new Random();

    @Override
    public int shoot() {
        return random.nextInt(3) + 1;
    }
}
