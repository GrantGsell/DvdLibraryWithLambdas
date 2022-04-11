package dvdlibrary.dao;
import dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Grant
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    // Hash Map containing Dvd database
    private Map<String, Dvd> mapDvd = new HashMap<>();
    
    // Constants for file name, delimeter
    private final String DATA_BASE;
    private static final String DELIMETER = ":::";
    
    // Constructors
    public DvdLibraryDaoFileImpl(){
        DATA_BASE = "dvdDataBase.txt";
    }
    
    public DvdLibraryDaoFileImpl(String filePath){
        DATA_BASE = filePath;
    }
    
       
    /**
     * Adds a dvd to the map associated with this instance of the class, then 
     *   writes the updated map to the db.
     * 
     * @param dvdId, the id for the dvd used as the map key.
     * @param dvd, the Dvd object used as the value for the map.
     * @return a Dvd object if the associated id was populated, null otherwise.
     * @throws DvdLibraryDaoException 
     */
    @Override
    public Dvd addDvd(String dvdId, Dvd dvd) throws DvdLibraryDaoException {
        // Read in db for data completeness
        this.readDataBase();
        
        // Insert the new dvd object into map
        Dvd newDvd = mapDvd.put(dvdId, dvd);
        
        // Write updated map to db
        this.writeDataBase();
        
        // Return Dvd object, null if inserted successfully
        return newDvd;
    }

    
    /**
     * Returns a List of all Dvds stored in the database.
     * 
     * @return a List of all Dvds in the database.
     * @throws DvdLibraryDaoException 
     */
    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException{
        // Read in db for data completeness
        this.readDataBase();
        
        // Convert, return dvd data
        return new ArrayList<>(mapDvd.values());   
    }

    
    /**
     * Obtains a singular Dvd object associated provided id.
     * 
     * @param dvdId the id for the particular Dvd object in question.
     * @return A Dvd object if one exists with the associated id, null 
     *   otherwise.
     * @throws DvdLibraryDaoException 
     */
    @Override
    public Dvd getDvd(String dvdId) throws DvdLibraryDaoException {
        // Read in db for data completeness
        this.readDataBase();
        
        // Return the Dvd specified by dvdId
        return mapDvd.get(dvdId);
    }

    
    /**
     * Removed a Dvd from the database based on the provided id parameter.
     * 
     * @param dvdId an id to specify which Dvd object to remove.
     * @return the Dvd object that was removed, null if the key provided does 
     *   not have an associated Dvd object.
     * @throws DvdLibraryDaoException 
     */
    @Override
    public Dvd removeDvd(String dvdId) throws DvdLibraryDaoException{
        // Read in db for data completeness
        this.readDataBase();
        
        // Remove the selected object
        Dvd removedDvd = mapDvd.remove(dvdId);
        
        // Write the updated map to the db
        this.writeDataBase();
        
        // Return Dvd object, null if key was not populated
        return removedDvd;
    }
    
    
    /**
     * Transforms (marshals) object field data into a string with delimeter's 
     *   in between each field. The string has the structure
     * 
     * @param dvd, the Dvd object to extract data from.
     * @return a string denoting the Dvd object as a string.
     */
    private String marshal(Dvd dvd){
        // Create StringBuilder variable to hold object data
        StringBuilder dvdAsString = new StringBuilder();
        
        // Add Dvd id, delimeter to sb
        dvdAsString.append(dvd.getId()).append(DELIMETER);
        
        // Add Dvd title, delimeter to sb
        dvdAsString.append(dvd.getTitle()).append(DELIMETER);
        
        // Add releaseDate, delimeter to sb
        dvdAsString.append(dvd.getReleaseData()).append(DELIMETER);
        
        // Add mpaaReatingm, delimeter to sb
        dvdAsString.append(dvd.getMpaaRating()).append(DELIMETER);
        
        // Add director, delimeter to sb
        dvdAsString.append(dvd.getDirector()).append(DELIMETER);
        
        // Add studio name, delimeter to sb
        dvdAsString.append(dvd.getStudio()).append(DELIMETER);
        
        // Add userRating, delimter to sb                
        dvdAsString.append(dvd.getUserRating());
        
        // Convert stringbuilder to string, return 
        return dvdAsString.toString();
    }
    
    
    /**
     * Unmarshals Dvd data from a single string into a new Dvd object.
     * 
     * @param dvdAsText, a string denoting Dvd object data.
     * @return Dvd object containing all of the info from dvdAsText in object 
     *   form.
     */
    private Dvd unmarshal(String dvdAsText){
        // Create String array for dvd text split
        String[] dvdData;
        
        // Create Dvd object to hold new data
        Dvd dvd = new Dvd();
        
        // Split the dvd string based on delimeter
        dvdData = dvdAsText.split(DELIMETER, 7);
        
        // Set dvd id
        dvd.setId(dvdData[0]);
        
        // Set dvd title
        dvd.setTitle(dvdData[1]);
        
        // Set releaseData
        dvd.setReleaseData(dvdData[2]);
        
        // Set dvd mpaaRating
        dvd.setMpaaRating(dvdData[3]);
        
        // Set dvd director 
        dvd.setDirector(dvdData[4]);
        
        // Set dvd studio
        dvd.setStudio(dvdData[5]);
        
        // Set user rating
        dvd.setUserRating(dvdData[6]);
        
        // Return populated dvd object
        return dvd;
    }
    
    
    /**
     * Read in all of the data from the database and stores it in the HashMap
     *   associated with this object instance.
     * 
     * @throws DvdLibraryDaoException 
     * Note: The string being read in should appear like so in this exact order:
     * 
     * Id | Title | Release Date | Mpaa Rating | Director | Studio | User Rating
     *  0 |   1   |      2       |      3      |     4    |    5   |     6  
     * 
     */
    private void readDataBase() throws DvdLibraryDaoException{
        // Create scanner object to read in data from file
        Scanner scan;
        
        // Create string to hold object as text
        String currLine;
        
        // Create dvd object to hold unmarshaled data
        Dvd currDvd;
        
        // Ensure the file exists
        try{
            scan = new Scanner(new BufferedReader(new FileReader(DATA_BASE)));
        }catch(IOException e){
            throw new DvdLibraryDaoException("Could not read from database", e);
        }
        
        // Loop through all lines of the text file
        while(scan.hasNextLine()){
            // Obtain the next line of text
            currLine = scan.nextLine();
            
            // Unmarshal text line into a Dvd object
            currDvd = unmarshal(currLine);
            
            // Put the current Dvd object into the hashmap
            mapDvd.put(currDvd.getId(), currDvd);
        }
        // Close the scanner to prevent meory leaks
        scan.close();
        
    }
    
    
    /**
     * Writes data to the database file, using the data from the HashMap 
     *   associated with this object.
     * 
     * @throws DvdLibraryDaoException 
     * Note: The string being written will appear like so in this exact order:
     * 
     * Id | Title | Release Date | Mpaa Rating | Director | Studio | User Rating
     *  0 |   1   |      2       |      3      |     4    |    5   |     6  
     * 
     */
    private void writeDataBase() throws DvdLibraryDaoException{      
        // Create variable to hold all Dvd data
        List<Dvd> dvdList;
        
        // Create new PrintWriter object for writing to text file
        PrintWriter out;
        
        // Open the existing text file
        try {
            out = new PrintWriter(new FileWriter(DATA_BASE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not write to database", e);
        }
        
        // Set dvd list, iterate through all of them
        dvdList = this.getAllDvds();
        for(Dvd currDvd : dvdList){
            // Marshal dvd object data into string
            String currentDvdAsText = this.marshal(currDvd);
            
            // Write the current Dvd text data 
            out.println(currentDvdAsText);
            
            // Force PrintWriter to write the line to the file
            out.flush();
        }
        // Close the PrintWriter to prevent memory leak
        out.close();
    }

    
    /*
        will return a list containing all the dvs that were release up to
        N years ago from teh current year.
    */
    @Override
    public List<Dvd> releasedInNYears(int years) throws DvdLibraryDaoException {
        final int year = Calendar.getInstance().get(Calendar.YEAR) - years;
                
        return  mapDvd.values().stream().filter((dvd) -> Integer.parseInt(dvd.getReleaseData()) >= year).collect(Collectors.toList());
             
    }

    @Override
    public List<Dvd> displayByRating(String rating) throws DvdLibraryDaoException {
        
        return mapDvd.values().stream().filter((dvd) -> dvd.getMpaaRating().equalsIgnoreCase(rating)).collect(Collectors.toList());
        
    }

    @Override
    public List<Dvd> displayByDirector(String director) {
        
        return mapDvd.values().stream().filter((dvd) -> dvd.getDirector().equalsIgnoreCase(director)).collect(Collectors.toList());
    }
}
