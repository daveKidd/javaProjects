package videogames.domain;

import org.junit.jupiter.api.Test;
import videogames.data.DataAccessException;
import videogames.data.VideoGameRepository;
import videogames.data.VideoGameRepositoryDouble;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameServiceTest {
    VideoGameRepository repository = new VideoGameRepositoryDouble();
    VideoGameService service = new VideoGameService(repository);

    @Test
    void shouldFindAll() throws DataAccessException {
        List<VideoGame> actual = service.findAll();
        assertEquals(3,actual.size());

        VideoGame videoGame = actual.get(0);
        assertEquals(1,videoGame.getId());
        assertEquals("The Last of Us",videoGame.getTitle());
        assertEquals(VideoGameConsole.PS5,videoGame.getConsole());
        assertEquals(70,videoGame.getPrice());
    }

    @Test
    void shouldCreateVideoGame() throws DataAccessException{
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,40));
        assertTrue(actual.isSuccess());
        assertNotNull(actual.getVideoGame());
        assertEquals(42,actual.getVideoGame().getId());
    }

    @Test
    void shouldNotCreateNullVideoGame() throws DataAccessException{
        VideoGameResult actual = service.create(null);
        assertFalse(actual.isSuccess());
    }

    @Test
    void shouldNotCreateExistingVideoGame() throws DataAccessException{
        VideoGameResult actual = service.create(new VideoGame(2, "Mario Kart 8", VideoGameConsole.SWITCH,40));
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("existing"));
    }

    @Test
    void shouldNotCreateWithNullTitle() throws DataAccessException{
        VideoGameResult actual = service.create(new VideoGame(0, null, VideoGameConsole.SWITCH,40));
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Title is required",actual.getMessages().get(0));
    }


    @Test
    void shouldNotCreateWithEmptyTitle() throws DataAccessException{
        VideoGameResult actual = service.create(new VideoGame(0, "", VideoGameConsole.SWITCH,40));
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Title is required",actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithoutConsoleType() throws DataAccessException{
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", null,40));
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Console is required",actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithInvalidPrice() throws DataAccessException{
        VideoGameResult actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,71));
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Price must be between 1 and 70",actual.getMessages().get(0));

        actual = service.create(new VideoGame(0, "Mario Kart 8", VideoGameConsole.SWITCH,0));
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Price must be between 1 and 70",actual.getMessages().get(0));
    }

    @Test
    void shouldUpdateExistingVideoGame() throws DataAccessException {
        List<VideoGame> all = service.findAll();
        VideoGame toUpdate = all.get(0);
        toUpdate.setPrice(5);

        VideoGameResult actual = service.update(toUpdate);
        assertTrue(actual.isSuccess());
        assertEquals(0,actual.getMessages().size());
    }

    @Test
    void shouldNotUpdateNullVideoGame() throws DataAccessException {
        VideoGameResult actual = service.update(null);
        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Video game can't be null",actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateNonExistingVideoGame() throws DataAccessException {
        VideoGame videoGame = new VideoGame(0, "FAKE", VideoGameConsole.SWITCH,11);
        VideoGameResult actual = service.update(videoGame);

        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertEquals("Video game not found",actual.getMessages().get(0));
    }
}