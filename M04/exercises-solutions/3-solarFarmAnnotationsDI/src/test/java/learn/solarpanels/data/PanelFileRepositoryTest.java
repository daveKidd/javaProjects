package learn.solarpanels.data;

import learn.solarpanels.models.MaterialType;
import learn.solarpanels.models.Panel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanelFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/solarpanels-seed.txt"; // sets up seed txt file
    static final String TEST_FILE_PATH = "./data/solarpanels-test.txt"; // sets up test txt file

    // this creates a new instance and passes in the test file path to the PanelFileRepository constructor
    PanelFileRepository repository = new PanelFileRepository(TEST_FILE_PATH);

    @BeforeEach
    void setupTest() throws IOException{
        Path seedPath = Paths.get(SEED_FILE_PATH); // Path and Paths is a java nio class that helps handle file paths
        Path testPath = Paths.get(TEST_FILE_PATH);

        // this uses the Files class from java nio to copy the seed data into the test txt file before each test
        Files.copy(seedPath,testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataAccessException{
        List<Panel> actual = repository.findAll();
        assertEquals(7,actual.size());
    }

    @Test
    void findBySection() throws DataAccessException{
        List<Panel> actual = repository.findBySection("Disneyland");
        assertEquals(2,actual.size());

        actual = repository.findBySection("Las Vegas");
        assertEquals(3,actual.size());
    }

    @Test
    void findBySectionRowColumn() throws DataAccessException{
        //finding Disneyland~1~2
        Panel actual = repository.findBySectionRowCol("Disneyland",1,2);
        assertNotNull(actual);
        assertEquals("Disneyland", actual.getSection());
        assertEquals(1, actual.getRow());
        assertEquals(2, actual.getColumn());
    }

    @Test
    void shouldAddPanel() throws DataAccessException{
        Panel panel = new Panel();
        panel.setSection("New York City");
        panel.setRow(2);
        panel.setColumn(3);
        panel.setYear(1900);
        panel.setMaterial(MaterialType.CADMIUM_TELLURIDE);
        panel.setTracking(true);

        Panel actual = repository.add(panel);
        assertEquals("New York City",actual.getSection());
        assertEquals(1900,actual.getYear());

        List<Panel> all = repository.findAll();
        assertEquals(8,all.size());
    }

    @Test
    void shouldUpdateExistingPanel() throws DataAccessException{
        //updating Disneyland~1~2
        Panel panel = new Panel();
        panel.setSection("Disneyland");
        panel.setRow(1);
        panel.setColumn(2);
        panel.setYear(2000);
        panel.setMaterial(MaterialType.AMORPHOUS_SILICON);
        panel.setTracking(false);

        boolean success = repository.update(panel);
        assertTrue(success);

        List<Panel> actual = repository.findBySection("Disneyland");
        assertNotNull(actual);
        assertEquals("Disneyland",actual.get(0).getSection());
        assertEquals(1,actual.get(0).getRow());
        assertEquals(2,actual.get(0).getColumn());
        assertEquals(2000,actual.get(0).getYear());
        assertEquals(MaterialType.AMORPHOUS_SILICON,actual.get(0).getMaterial());
        assertEquals(false,actual.get(0).isTracking());
    }

    @Test
    void shouldNotUpdateNonExistingPanel() throws DataAccessException{
        Panel panel = new Panel();
        panel.setSection("The Moon");
        panel.setRow(100);
        panel.setColumn(200);

        boolean actual = repository.update(panel);
        assertFalse(actual);
    }

    @Test
    void shouldDeletePanel() throws DataAccessException{
        //deleting Idaho Falls~40~85
        boolean success = repository.deleteBySectionRowCol("Idaho Falls",40,85);
        assertTrue(success);

        // this should be the only one left Idaho Falls~100~200~2019
        List<Panel> actual = repository.findBySection("Idaho Falls");
        assertNotNull(actual);
        assertEquals("Idaho Falls",actual.get(0).getSection());
        assertEquals(100,actual.get(0).getRow());
        assertEquals(200,actual.get(0).getColumn());
        assertEquals(2019,actual.get(0).getYear());
        assertEquals(MaterialType.MULTICRYSTALLINE_SILICON,actual.get(0).getMaterial());
        assertEquals(true,actual.get(0).isTracking());
    }
}