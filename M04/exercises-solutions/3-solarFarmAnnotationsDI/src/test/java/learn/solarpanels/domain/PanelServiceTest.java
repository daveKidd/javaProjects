package learn.solarpanels.domain;

import learn.solarpanels.data.DataAccessException;
import learn.solarpanels.data.PanelFileRepository;
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

class PanelServiceTest {
    static final String SEED_FILE_PATH = "./data/solarpanels-seed.txt"; // sets up seed txt file
    static final String TEST_FILE_PATH = "./data/solarpanels-test.txt";
    PanelService service = new PanelService(new PanelFileRepository(TEST_FILE_PATH));

    @BeforeEach
    void setupTest() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH); // Path and Paths is a java nio class that helps handle file paths
        Path testPath = Paths.get(TEST_FILE_PATH);

        // this uses the Files class from java nio to copy the seed data into the test txt file before each test
        Files.copy(seedPath,testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void shouldFindBySection() throws DataAccessException{
        List<Panel> panels = service.findBySection("Idaho Falls");
        assertNotNull(panels);
        assertEquals(2,panels.size());
    }

    @Test
    void shouldBeAbleToAddPanel() throws DataAccessException{
        PanelResult result = service.add(new Panel("Las Vegas",2,2,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldBeAbleToUpdatePanel() throws DataAccessException{
        // updating Disneyland~1~3~1989~MULTICRYSTALLINE_SILICON~false
        PanelResult result = service.update(new Panel("Disneyland",1,3,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldBeAbleToDeletePanel() throws DataAccessException{
        PanelResult result = service.deleteBySectionRowCol("Disneyland",1,3);
        assertTrue(result.isSuccess());
    }


    /* Info check tests*/

    @Test
    void shouldNotAddNullPanel() throws DataAccessException{
        // this isn't running the add from PanelFileRepository, it's running it from PanelService
        // when then calls it from PanelFileRepository and runs all the checks on it such
        PanelResult result = service.add(null);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddBlankSection() throws DataAccessException{
        PanelResult result = service.add(new Panel("",2,2,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotBeAbleToAddLargeSmallRow() throws DataAccessException{
        PanelResult result = service.add(new Panel("Las Vegas",300,2,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertFalse(result.isSuccess());

        PanelResult result2 = service.add(new Panel("Las Vegas",-300,2,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertFalse(result2.isSuccess());
    }

    @Test
    void shouldNotBeAbleToAddLargeSmallCol() throws DataAccessException{
        PanelResult result = service.add(new Panel("Las Vegas",3,300,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertFalse(result.isSuccess());

        PanelResult result2 = service.add(new Panel("Las Vegas",3,-300,1980,MaterialType.AMORPHOUS_SILICON,true));
        assertFalse(result2.isSuccess());
    }

    @Test
    void yearShouldBeInPast() throws DataAccessException{
        PanelResult result = service.add(new Panel("Las Vegas",3,56,2050,MaterialType.AMORPHOUS_SILICON,false));
        assertFalse(result.isSuccess());
    }

    @Test
    void cantHaveExistingSectionRowCol() throws DataAccessException{
        PanelResult result = service.add(new Panel("Disneyland",1,2,2010,MaterialType.COPPER_INDIUM_GALLIUM_SELENIDE,false));
        assertFalse(result.isSuccess());
    }




}