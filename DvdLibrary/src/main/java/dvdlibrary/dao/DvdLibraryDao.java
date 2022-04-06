package dvdlibrary.dao;
import dvdlibrary.dto.Dvd;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Grant
 */
public interface DvdLibraryDao {
    
    /**
     * Adds a given Dvd object to the database and associates it with the 
     *   provided id. If the id is already in use the Dvd object that's already 
     *   associated with that id will be returned, otherwise null;
     * 
     * @param dvdId, a unique identifier for the associated Dvd object.
     * @param dvd, the Dvd object to be added to the db.
     * @return the Dvd object associated with the id if already present, 
     *   otherwise null.
     */    
    Dvd addDvd(String dvdId, Dvd dvd) throws DvdLibraryDaoException;
    
    
    /**
     * 
     * @return 
     */
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;
    
    
    /**
     * 
     * @param dvdId
     * @return 
     */
    Dvd getDvd(String dvdId) throws DvdLibraryDaoException;
    
    
    /**
     * 
     * @param dvdId
     * @return 
     */
    Dvd removeDvd(String dvdId) throws DvdLibraryDaoException;
    
    
}
