package dvdlibrary.ui;

import java.util.List;
import dvdlibrary.dto.Dvd;

public class DvdLibraryView {

    // Display menu selection

    private UserIO io = new UserIOConsoleImpl();

    // Note: Re-using code from StudentQuiz & Class Roster programs
    public int getMenuSelection()
    {
        io.print("Main Menu");
        io.print("1. Add DVD to Collection");
        io.print("2. Remove a DVD from Collection");
        io.print("3. Edit a DVD ");
        io.print("4. List the DVDs in the collection");
        io.print("5. Display info of a particular DVD");
        io.print("6. Search a DVD by Title");

        return io.readInt("Select one of the choices above:");
    }
    

    // Display the DVD List 
    public void displayDvdList (List<Dvd> DVDLibrary) //or should it be displayDVDLibrary ?
    {
        for (Dvd currentDVD : DVDLibrary)
        {
            String dvdInfo = String.format("DVDid: %s DVDTitle: %s DVDDate: %s MPAARating : %s DirectorName : %s Studio : %s UserRating : %s" ,
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
    public Dvd getDvdInfo()
    {
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

    public void displayDvdInfo(Dvd dvd)
    {
        io.print(dvd.getTitle());
        io.print(dvd.getId());
        io.print(dvd.getReleaseData());
        io.print(dvd.getMpaaRating());
        io.print(dvd.getDirector());
        io.print(dvd.getStudio());
        io.print(dvd.getUserRating());
        
    }

    public String getDvdTitle()
    {
        String title = io.readString("What is the Title of the DVD?: ");
        return title;
    }

    public String getDvdId()
    {
        String Id = io.readString("What is the DVD's ID?: ");
        return Id;
    }

    public void displayExitBanner() 
    {
        io.print("=== Good Bye! ===");
    }

    public void displayUnknownCommandBanner() 
    {
        io.print("=== Unknown Command ===");
    }

    public void displayAddDvdBanner() 
    {
        io.print("=== Add DVD ===");
    }

    public void displayAddDvdSuccessBanner() 
    {
        io.print("=== Success! ===");
    }

    public void displayRemoveDvdBanner() 
    {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveDvdSuccessBanner() 
    {
        io.print("=== Success! ===");
    }

    public void displayListDvdsBanner() 
    {
        io.print("=== List Of DVDs ===");
    }

    public void displayViewDvdBanner() 
    {
        io.print("=== DVD Details ===");
    }

    public void displaySearchDvdBanner() 
    {
        io.print("=== DVD Search ===");
    }

    public void displayEditDvdBanner() 
    {
        io.print("=== Edit DVD ===");
    }
    
    public void displayEditDvdSuccessBanner() 
    {
        io.print("=== Success! ===");
    }

}
