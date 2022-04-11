package dvdlibrary.ui;

import java.util.List;
import dvdlibrary.dto.Dvd;

public class DvdLibraryView {

    // Display menu selection
    private UserIO io = new UserIOConsoleImpl();

    // Note: Re-using code from StudentQuiz & Class Roster programs
    public int getMenuSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD to Collection");
        io.print("2. Remove a DVD from Collection");
        io.print("3. Edit a DVD ");
        io.print("4. List the DVDs in the collection");
        io.print("5. Display info of a particular DVD");
        io.print("6. Search a DVD by Title");
        io.print("7. Find all movies released in the last N years");
        io.print("8. Find all the movies with a given MPAA rating");
        io.print("9. Find all the movies by a given director");
        io.print("10. Find all the movies released by a particular studio");
        io.print("11. Find the average age of the movies in the collection");
        io.print("12. Find the newest movie in your collection");
        io.print("13. Find the oldest movie in your collection");
        io.print("14. Find the average number of notes associated with movies in your collection");
        io.print("15. Exit the application.");

        return io.readInt("Select one of the choices above:");
    }

    // Display the DVD List 
    public void displayDvdList(List<Dvd> DVDLibrary) //or should it be displayDVDLibrary ?
    {
        for (Dvd currentDVD : DVDLibrary) {
            String dvdInfo = String.format("DVDid: %s DVDTitle: %s DVDDate: %s MPAARating : %s DirectorName : %s Studio : %s UserRating : %s",
                    currentDVD.getId(),
                    currentDVD.getTitle(),
                    currentDVD.getReleaseData(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirector(),
                    currentDVD.getStudio(),
                    currentDVD.getUserRating());

            io.print(dvdInfo);
        }
        io.readString("Hit enter to continue.");
    }

    //Display DVD info <--Should this go above the display list method?
    public Dvd getDvdInfo() {
        String title = io.readString("Enter DVD Title:");
        String releaseData = io.readString("Enter DVD Release Date:");
        String mpaaRating = io.readString("Enter MPAA Rating:");
        String director = io.readString("Enter name of Director:");
        String studio = io.readString("Enter Studio:");
        String userRating = io.readString("Enter user rating:");
        String dvdId = io.readString("Enter DVD ID:");
        Dvd currentDvd = new Dvd();
        currentDvd.setId(dvdId);
        currentDvd.setDirector(director);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setReleaseData(releaseData);
        currentDvd.setStudio(studio);
        currentDvd.setTitle(title);
        currentDvd.setUserRating(userRating);
        return currentDvd;

    }

    public void displayDvdInfo(Dvd dvd) {
        io.print(dvd.getTitle());
        io.print(dvd.getId());
        io.print(dvd.getReleaseData());
        io.print(dvd.getMpaaRating());
        io.print(dvd.getDirector());
        io.print(dvd.getStudio());
        io.print(dvd.getUserRating());

    }
    
    public void displayAverageAge(double avg){
        io.print("The average age of the Dvds in the collection is " + avg);
    }
    
    public void displayByStudio(List<Dvd> list){
        displayDvdList(list);
    }

    public String getNYears() {
        String nYears = io.readString("Filter for movies released in the last how many years?");
        return nYears;
    }

    public String getSearchByMpaaRating() {
        String mpaaRatingInput = io.readString("Enter an MPAA rating for which to filter");
        return mpaaRatingInput;
    }

    public String getSearchByDirector() {
        String directorSearchInput = io.readString("Enter a Director for whom to filter");
        return directorSearchInput;
    }

    public String getDvdTitle() {
        String title = io.readString("What is the Title of the DVD?: ");
        return title;
    }

    public String getDvdId() {
        String Id = io.readString("What is the DVD's ID?: ");
        return Id;
    }
    
    public String searchByStudio(){
        String studio = io.readString("Enter a studio to filter the movies by: ");
        return studio;
    }

    public void displayExitBanner() {
        io.print("=== Good Bye! ===");
    }

    public void displayUnknownCommandBanner() {
        io.print("=== Unknown Command ===");
    }

    public void displayAddDvdBanner() {
        io.print("=== Add DVD ===");
    }

    public void displayAddDvdSuccessBanner() {
        io.print("=== Success! ===");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveDvdSuccessBanner() {
        io.print("=== Success! ===");
    }

    public void displayListDvdsBanner() {
        io.print("=== List Of DVDs ===");
    }

    public void displayViewDvdBanner() {
        io.print("=== DVD Details ===");
    }

    public void displaySearchDvdBanner() {
        io.print("=== DVD Search ===");
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccessBanner() {
        io.print("=== Success! ===");
    }

    public void displaySearchByNYearsBanner() {
        io.print("=== DVD Search by Years ===");
    }

    public void displaySearchByMpaaRatingsBanner() {
        io.print("=== DVD Search by MPAA Rating ===");
    }

    public void displaySearchByDirectorBanner() {
        io.print("=== DVD Search by Director Name ===");
    }
    
    public void displayByStudioBanner(){
        io.print("=== DVD Search by Studio ===");
    }
    
    public void displayAverageAgeBanner(){
        io.print("=== Average age of movies in the collection ===");
    }
    
}
