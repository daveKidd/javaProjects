package videogames.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoGameJdbcTemplateRepositoryTest {
    @Autowired
    VideoGameRepository repository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    static boolean hasRun = false;
    @BeforeEach
    void setup(){
        if(!hasRun){
            jdbcTemplate.update("call set_known_good_state();");
            hasRun = true;
        }
    }

    @Test
    void shouldFindAllVideoGames()  {
        //'Ghost of Tsushima: Director''s Cut', 'PS5', 50.00, '2020-07-17', 1
        VideoGame expected = new VideoGame(1, "Ghost of Tsushima: Director's Cut", VideoGameConsole.PS5,
                new BigDecimal("50.00"), LocalDate.parse("2020-07-17"), true);
        List<VideoGame> allGames = repository.findAll();

        assertNotNull(allGames);
        assertTrue(allGames.size() >= 2);
        assertTrue(allGames.stream().anyMatch(g -> g.equals(expected)));
    }

    @Test
    void shouldFindGhostOfTsushima() {
        VideoGame expected = new VideoGame(1, "Ghost of Tsushima: Director's Cut", VideoGameConsole.PS5,
                new BigDecimal("50.00"), LocalDate.parse("2020-07-17"), true);

        VideoGame actual = repository.findById(1);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateVideoGame() {
        VideoGame videoGame = new VideoGame(0, "Super Smash Bros.", VideoGameConsole.SWITCH,
                new BigDecimal("50.00"), LocalDate.parse("2017-01-01"), false);
        VideoGame expected = new VideoGame(4, "Super Smash Bros.", VideoGameConsole.SWITCH,
                new BigDecimal("50.00"), LocalDate.parse("2017-01-01"), false);

        VideoGame added = repository.create(videoGame);

        assertEquals(expected, added);
    }

    @Test
    void shouldUpdateVideoGame() {
        // 'Ratchet and Clank: Rift Apart' ,'PS5', 40.00, '2021-06-11', 1
        VideoGame videoGame = new VideoGame(2, "Ratchet and Clank: Drift Apart", VideoGameConsole.PC,
                new BigDecimal("100.00"), LocalDate.parse("2022-05-03"), true);

        assertTrue(repository.update(videoGame));

        VideoGame updated = repository.findById(2);

        assertEquals(videoGame, updated);
    }

    @Test
    void shouldNotUpdateMissingVideoGame() {
        VideoGame videoGame = new VideoGame(99, "World of Goo", VideoGameConsole.PC,
                new BigDecimal("10.00"), LocalDate.parse("2022-05-03"), true);

        assertFalse(repository.update(videoGame));
    }

    @Test
    void shouldDeleteVideoGame() {
        assertTrue(repository.deleteById(3));
        assertFalse(repository.deleteById(3));
    }

}