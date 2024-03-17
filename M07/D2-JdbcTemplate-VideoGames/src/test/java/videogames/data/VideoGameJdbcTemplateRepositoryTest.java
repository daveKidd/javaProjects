package videogames.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameJdbcTemplateRepositoryTest {

    private final VideoGameRepository repository;

    VideoGameJdbcTemplateRepositoryTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestDbConfig.class);
        repository = context.getBean(VideoGameRepository.class);
    }

    @BeforeAll
    static void setup() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestDbConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        jdbcTemplate.update("call set_known_good_state();");
    }

    @Test
    void shouldFindAllVideoGames() throws DataAccessException {
        VideoGame expected = new VideoGame(1,"Ghost of Tsushima: Director's Cut", VideoGameConsole.PS5,
                new BigDecimal("50.00"), LocalDate.parse("2020-07-17"), true);

        List<VideoGame> allGames = repository.findAll();

        assertNotNull(allGames);
        assertTrue(allGames.size() >= 2);
        assertTrue(allGames.stream().anyMatch(g -> g.equals(expected)));
    }

    @Test
    void shouldGhostOfTsushima() throws DataAccessException {
        VideoGame expected = new VideoGame(1,"Ghost of Tsushima: Director's Cut", VideoGameConsole.PS5,
                new BigDecimal("50.00"), LocalDate.parse("2020-07-17"), true);

        VideoGame actual = repository.findById(1);

        assertNotNull(actual);
        assertEquals(expected,actual);
    }

    @Test
    void shouldCreateVideoGame() throws DataAccessException {
        VideoGame videoGame = new VideoGame(0,"Crypt of the Necrodancer", VideoGameConsole.PC,
                new BigDecimal("15.00"), LocalDate.parse("2015-04-23"), true);

        VideoGame expected = new VideoGame(4,"Crypt of the Necrodancer", VideoGameConsole.PC,
                new BigDecimal("15.00"), LocalDate.parse("2015-04-23"), true);

        VideoGame actual = repository.create(videoGame);

        assertEquals(expected,actual);
    }

    @Test
    void shouldUpdateVideoGame() throws DataAccessException {
        //'Ratchet and Clank: Rift Apart' ,'PS5', 40.00, '2021-06-11', 1
        VideoGame videoGame = new VideoGame(2, "Ratchet and Clank: Drift Apart", VideoGameConsole.PC,
                new BigDecimal("50.00"), LocalDate.parse("2022-08-22"),true);

        assertTrue(repository.update(videoGame));

        VideoGame updated = repository.findById(2);
        assertEquals(videoGame,updated);
    }

    @Test
    void shouldNotUpdateNonExistingVideoGame() throws DataAccessException {
        VideoGame videoGame = new VideoGame(99, "I don't exist", VideoGameConsole.PC,
                new BigDecimal("1.00"), LocalDate.parse("2022-08-22"),true);

        assertFalse(repository.update(videoGame));
    }

    @Test
    void shouldDeleteVideoGame() throws DataAccessException{
        assertTrue(repository.deleteById(3));
        assertFalse(repository.deleteById(3));
    }


}