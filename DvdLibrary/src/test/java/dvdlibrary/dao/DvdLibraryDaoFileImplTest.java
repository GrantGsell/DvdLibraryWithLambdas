package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.io.FileWriter;
import java.util.HashSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Grant
 */
public class DvdLibraryDaoFileImplTest {
    DvdLibraryDao testDao;
    
    public DvdLibraryDaoFileImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testDb.txt";
        
        // Clear file
        new FileWriter(testFile);
        testDao = new DvdLibraryDaoFileImpl(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testAddGetDvd() throws Exception{
        // Create new Dvd
        Dvd newDvd = new Dvd();
        String dvdId = "0";
        newDvd.setId(dvdId);
        newDvd.setDirector("");
        newDvd.setMpaaRating("");
        newDvd.setReleaseData("");
        newDvd.setStudio("");
        newDvd.setTitle("");
        newDvd.setUserRating("");
        
        // Add the student to the DAO
        testDao.addDvd(dvdId, newDvd);
        
        // Retrieve Dvd
        Dvd retrieveDvd = testDao.getDvd(dvdId);
        
        // Make Assertion
        assertEquals(newDvd.getId(), retrieveDvd.getId(), "Checking Dvd id");
        assertEquals(newDvd.getTitle(), retrieveDvd.getTitle(), "Checking Dvd title");
        assertEquals(newDvd.getDirector(), retrieveDvd.getDirector(), "Checking Dvd director");
        assertEquals(newDvd.getMpaaRating(), retrieveDvd.getMpaaRating(), "Checking Dvd Mpaa");
        assertEquals(newDvd.getReleaseData(), retrieveDvd.getReleaseData(), "Checking Dvd Release Date");
        assertEquals(newDvd.getStudio(), retrieveDvd.getStudio(), "Checking Dvd Studio");
        assertEquals(newDvd.getUserRating(), retrieveDvd.getUserRating(), "Checking Dvd User Ratin");
        
    }
}
