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
     * Returns a List of all Dvds stored in the database.
     * 
     * @return a List containing all Dvds stored in the database.
     */
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;
    
    
    /**
     * Gets a singular Dvd object based on its associated dvdId.
     * 
     * @param dvdId the id for an associated Dvd object.
     * @return a Dvd object if one already exists for that key, null otherwise.
     */
    Dvd getDvd(String dvdId) throws DvdLibraryDaoException;
    
    
    /**
     * Removes a Dvd object from the database according to the provided id.
     * 
     * @param dvdId the id of the Dvd object to be removed.
     * @return the Dvd object that was removed, null otherwise.
     */
    Dvd removeDvd(String dvdId) throws DvdLibraryDaoException;
    
    
}
