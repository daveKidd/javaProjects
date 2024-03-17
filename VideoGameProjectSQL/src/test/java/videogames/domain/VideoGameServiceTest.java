package videogames.domain;

import org.junit.jupiter.api.Test;
import videogames.data.VideoGameRepository;
import videogames.data.VideoGameRepositoryDouble;
import videogames.models.VideoGame;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameServiceTest {

    VideoGameRepository repository = new VideoGameRepositoryDouble();
    VideoGameService service = new VideoGameService(repository);

    @Test
    void shouldFindAll() {
        List<VideoGame> actual = service.findAll();
        assertEquals(3, actual.size());

        //1,"The Last of Us", VideoGameConsole.PS5,70
        VideoGame videoGame = actual.get(0);
        assertEquals(1, videoGame.getId());
        assertEquals("The Last of Us", videoGame.getTitle());
        assertEquals(new BigDecimal("70.00"), videoGame.getPrice());
    }

    @Test
    void shouldCreateVideoGame() {
        Result<VideoGame> actual = service.create(new VideoGame(0, "Mario Kart 8",
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false,1));

        assertTrue(actual.isSuccess());
        assertNotNull(actual.getPayload());
        assertEquals(42, actual.getPayload().getId());
    }

    @Test
    void shouldNotCreateNullVideoGame() {
        Result<VideoGame> actual = service.create(null);
        assertFalse(actual.isSuccess());
    }

    @Test
    void shouldNotCreateExistingVideoGame() {
        Result<VideoGame> actual = service.create(new VideoGame(1, "Mario Kart 8",
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("existing"));
    }

    @Test
    void shouldNotCreateWithNullTitle() {
        Result<VideoGame> actual = service.create(new VideoGame(0, null,
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Title is required", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithEmptyTitle() {
        Result<VideoGame> actual = service.create(new VideoGame(0, "",
                new BigDecimal("40.00"), LocalDate.parse("2014-05-29"), false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Title is required", actual.getMessages().get(0));
    }


    @Test
    void shouldNotCreateWithNullPrice() {
        Result<VideoGame> actual = service.create(new VideoGame(0, "Mario Kart 8",
                null, LocalDate.parse("2014-05-29"), false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Price must be between 1 and 70", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateInvalidPrice() {
        Result<VideoGame> actual = service.create(new VideoGame(0, "Mario Kart 8",
                new BigDecimal("71.00"), LocalDate.parse("2014-05-29"), false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Price must be between 1 and 70", actual.getMessages().get(0));

        actual = service.create(new VideoGame(0, "Mario Kart 8",
                new BigDecimal("0.00"), LocalDate.parse("2014-05-29"), false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Price must be between 1 and 70", actual.getMessages().get(0));
    }

    @Test
    void shouldNotAddCreateInvalidReleaseDate() {
        Result<VideoGame> actual = service.create(new VideoGame(0, "Mario Kart 8",
                new BigDecimal("59.00"), null, false,1));
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Release date is required", actual.getMessages().get(0));
    }

    @Test
    void shouldUpdateExistingVideoGame() {
        List<VideoGame> all = service.findAll();
        VideoGame toUpdate = all.get(0);
        toUpdate.setPrice(new BigDecimal("5.00"));

        Result<VideoGame> actual = service.update(toUpdate);
        assertTrue(actual.isSuccess());
        assertEquals(0, actual.getMessages().size());
    }

    @Test
    void shouldNotUpdateNullVideoGame() {
        Result<VideoGame> actual = service.update(null);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Video Game can't be null", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateNonExistingVideoGame() {
        VideoGame videoGame = new VideoGame(0, "FAKE",
                new BigDecimal("11.00"), LocalDate.parse("2014-05-29"), false,1);
        Result<VideoGame> actual = service.update(videoGame);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Video game doesn't exist", actual.getMessages().get(0));
    }

    @Test
    void shouldDeleteVideoGameById() {
        Result<Void> result = service.deleteById(2);
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotDeleteMissingVideoGameById() {
        Result<Void> actual = service.deleteById(3);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Video game: 3 doesn't exist", actual.getMessages().get(0));
    }
}