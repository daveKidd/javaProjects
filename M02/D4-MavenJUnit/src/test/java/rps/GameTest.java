package rps;

import org.junit.jupiter.api.*;
import rps.players.FixedPlayer;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    FixedPlayer alwaysRock = new FixedPlayer(Game.ROCK);
    FixedPlayer alwaysPaper = new FixedPlayer(Game.PAPER);
    FixedPlayer alwaysScissors = new FixedPlayer(Game.SCISSORS);

    @BeforeAll
    static void beforeTestsRun() {
        System.out.println("Before any tests run");
    }

    @BeforeEach
    void beforeEachTest(){
        System.out.println("Test is about to start");
    }

    @BeforeEach
    void beforeEachTest2(){
        System.out.println("Test is about to start -- I run before the other @BeforeEach");
    }

    @AfterEach
    void teardown(){
        System.out.println("Test is done");
    }

    @AfterAll
    static void closeOut(){
        System.out.println("All tests complete!");
    }

    @Test
    void rockShouldBeatScissors() {
        Game game = new Game(alwaysRock,alwaysScissors);
        int expected = 1;

        int actual = game.playRound();

        assertEquals(expected, actual, "rock should beat scissors");
    }

    @Test
    void paperShouldBeatRock() {

    }

    @Test
    void scissorsShouldBeatPaper() {

    }

    @Test
    void shouldTie() {

    }
}