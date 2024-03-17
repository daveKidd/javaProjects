package rps.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomPlayerTest {

    @Test
    void shouldReturnValidRandomNumber() {
        // arrange | act | assert
        RandomPlayer player = new RandomPlayer();
        for(int i = 0; i < 10000; i++){
            int actual = player.shoot();
            if(actual < 1 || actual > 3){
                fail("Received invalid random number" + actual);
            }
        }
    }
}