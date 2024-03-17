package videogames.domain;

import org.junit.jupiter.api.Test;
import videogames.data.DataAccessException;
import videogames.data.VideoGameRepository;
import videogames.data.VideoGameRepositoryDouble;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameServiceTest {

    VideoGameRepository repository = new VideoGameRepositoryDouble();
    VideoGameService service = new VideoGameService(repository);

    @Test
    void shouldFindAll() throws DataAccessException {
        List<VideoGame> actual = service.findAll();
        assertEquals(3, actual.size());

        //1,"The Last of Us", VideoGameConsole.PS5,70
        VideoGame videoGame = actual.get(0);
        assertEquals(1, videoGame.getId());
        assertEquals("The Last of Us", videoGame.getTitle());
        assertEquals(VideoGameConsole.PS5, videoGame.getConsole());
        assertEquals(new BigDecimal("70.00"), videoGame.getPrice());
    }

    @Test
    void shouldCreateVideoGame() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false));

        assertTrue(actual.isSuccess());
        assertNotNull(actual.getVideoGame());
        assertEquals(42, actual.getVideoGame().getId());
    }

    @Test
    void shouldNotCreateNullVideoGame() throws DataAccessException {
        VideoGameResult actual = service.create(null);
        assertFalse(actual.isSuccess());
    }

    @Test
    void shouldNotCreateExistingVideoGame() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(1, "Mario Kart 8", VideoGameConsole.SWITCH,
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("existing"));
    }

    @Test
    void shouldNotCreateWithNullTitle() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, null, VideoGameConsole.SWITCH,
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Title is required", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithEmptyTitle() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, "", VideoGameConsole.SWITCH,
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Title is required", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithoutConsoleType() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", null,
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Console is required", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithNullPrice() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,
                null, LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Price must be between 1 and 70", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateInvalidPrice() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,
                new BigDecimal("71.00"), LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Price must be between 1 and 70", actual.getMessages().get(0));

        actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,
                new BigDecimal("0.00"), LocalDate.parse("2014-05-29"), false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Price must be between 1 and 70", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddCreateInvalidReleaseDate() throws DataAccessException {
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,
                new BigDecimal("59.00"), null, false));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Release date is required", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateDuplicateVideoGame() throws DataAccessException {
        VideoGame videoGame = new VideoGame(0,"The Last of Us", VideoGameConsole.PS5,new BigDecimal("70.00"),
                LocalDate.parse("2013-06-14"), true);

        VideoGameResult actual = service.create(videoGame);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("'The Last of Us' for PS5 has already been added", actual.getMessages().get(0));
    }

    @Test
    void shouldUpdateExistingVideoGame() throws DataAccessException {
        List<VideoGame> all = service.findAll();
        VideoGame toUpdate = all.get(0);
        toUpdate.setPrice(new BigDecimal("5.00"));

        VideoGameResult actual = service.update(toUpdate);
        assertTrue(actual.isSuccess());
        assertEquals(0, actual.getMessages().size());
    }

    @Test
    void shouldNotUpdateNullVideoGame() throws DataAccessException {
        VideoGameResult actual = service.update(null);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Video Game can't be null", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateNonExistingVideoGame() throws DataAccessException {
        VideoGame videoGame = new VideoGame(0, "FAKE", VideoGameConsole.SWITCH,
                new BigDecimal("11.00"), LocalDate.parse("2014-05-29"), false);
        VideoGameResult actual = service.update(videoGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Video game doesn't exist", actual.getMessages().get(0));
    }

    @Test
    void shouldDeleteVideoGameById() throws DataAccessException {
        VideoGameResult result = service.deleteById(2);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotDeleteMissingVideoGameById() throws DataAccessException {
        VideoGameResult actual = service.deleteById(3);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Video game: 3 doesn't exist", actual.getMessages().get(0));
    }
}