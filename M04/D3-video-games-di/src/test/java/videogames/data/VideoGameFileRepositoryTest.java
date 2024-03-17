package videogames.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import videogames.models.VideoGame;
import videogames.models.VideoGameConsole;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        Files.copy(seedPath,testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindAll() throws DataAccessException {
        List<VideoGame> actual = repository.findAll();

        assertEquals(11, actual.size());

        VideoGame videoGame = actual.get(0);
        assertEquals(1,videoGame.getId());
        assertEquals("Ghost of Tsushima: Director's Cut",videoGame.getTitle());
        assertEquals(VideoGameConsole.PS5,videoGame.getConsole());
        assertEquals(50,videoGame.getPrice());
    }

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
        VideoGame videoGame = new VideoGame(0,"Call of Duty Modern Warfare",VideoGameConsole.PC,10);

        VideoGame actual = repository.create(videoGame);
        assertEquals(12, actual.getId());

        List<VideoGame> all = repository.findAll();
        assertEquals(12, all.size());

        VideoGame newVideoGame = all.get(11);
        assertEquals(actual,newVideoGame);
        assertEquals(12,videoGame.getId());
        assertEquals("Call of Duty Modern Warfare",videoGame.getTitle());
        assertEquals(VideoGameConsole.PC,videoGame.getConsole());
        assertEquals(10,videoGame.getPrice());
    }

    @Test
    public void shouldUpdate() throws DataAccessException {
        VideoGame videoGame = repository.findAll().get(2);
        videoGame.setTitle("Something Else");
        videoGame.setPrice(10);
        assertTrue(repository.update(videoGame));

        videoGame = repository.findAll().get(2);
        assertNotNull(videoGame);
        assertEquals("Something Else", videoGame.getTitle());
        assertEquals(10,videoGame.getPrice());

        VideoGame doesNotExist = new VideoGame(1024,"I am not inserted", VideoGameConsole.PS5,0);
        assertFalse(repository.update(doesNotExist));
    }

    @Test
    void shouldDeleteById() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteById(1));
        assertFalse(repository.deleteById(1024));
        assertEquals(count - 1, repository.findAll().size());
    }
}