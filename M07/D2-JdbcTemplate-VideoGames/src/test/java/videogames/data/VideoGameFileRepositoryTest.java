package videogames.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameFileRepositoryTest {
    private static final String TEST_FILE_PATH = "./data/video-games-test.csv";
    private static final String SEED_FILE_PATH = "./data/video-games-seed.csv";

    private final VideoGameFileRepository repository = new VideoGameFileRepository(TEST_FILE_PATH);

    @BeforeEach
    public void setup() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void shouldFindAll() throws DataAccessException {
        List<VideoGame> actual = repository.findAll();
        assertEquals(3, actual.size());

        //1,Ghost of Tsushima: Director's Cut,PS5,50
        VideoGame videoGame = actual.get(0);
        assertEquals(1, videoGame.getId());
        assertEquals("Ghost of Tsushima: Director's Cut", videoGame.getTitle());
        assertEquals(VideoGameConsole.PS5, videoGame.getConsole());
        assertEquals(new BigDecimal("50.00"), videoGame.getPrice());
    }

    // added after lecture
    @Test
    void shouldFindById() throws DataAccessException {
        VideoGame videoGame = repository.findById(2);
        assertNotNull(videoGame);
        //2,Ratchet and Clank: Rift Apart,PS5,40.0
        assertEquals("Ratchet and Clank: Rift Apart", videoGame.getTitle());
        assertEquals(VideoGameConsole.PS5, videoGame.getConsole());

        videoGame = repository.findById(1024);
        assertNull(videoGame);
    }

    @Test
    public void shouldCreate() throws DataAccessException {
        VideoGame videoGame = new VideoGame(0, "Spider Man", VideoGameConsole.PS5,
                new BigDecimal("30.00"), LocalDate.parse("2020-05-05"), true);
        VideoGame actual = repository.create(videoGame);
        assertNotNull(actual);

        List<VideoGame> all = repository.findAll();
        assertEquals(4, all.size());

        VideoGame newVideoGame = all.get(3);
        assertEquals(4, newVideoGame.getId());
        assertEquals("Spider Man", newVideoGame.getTitle());
        assertEquals(VideoGameConsole.PS5, newVideoGame.getConsole());
        assertEquals(new BigDecimal("30.00"), newVideoGame.getPrice());
    }

    //added after lecture
    @Test
    public void shouldUpdate() throws DataAccessException {
        VideoGame videoGame = repository.findAll().get(2);
        videoGame.setTitle("Something Else");
        videoGame.setPrice(BigDecimal.TEN);
        assertTrue(repository.update(videoGame));

        videoGame = repository.findAll().get(2);
        assertNotNull(videoGame);
        assertEquals("Something Else", videoGame.getTitle());
        assertEquals(BigDecimal.TEN, videoGame.getPrice());

        VideoGame doesNotExist = new VideoGame(1024, "I am not inserted", VideoGameConsole.PS5,
                BigDecimal.ZERO, LocalDate.parse("2022-01-01"), true);
        assertFalse(repository.update(doesNotExist));
    }

    //added after lecture
    @Test
    void shouldDeleteById() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1024));
        assertEquals(count - 1, repository.findAll().size());
    }
}