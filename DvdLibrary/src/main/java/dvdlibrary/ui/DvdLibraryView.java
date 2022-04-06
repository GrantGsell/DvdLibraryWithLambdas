public class DVDLibraryView {

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
    public void displayDVDList (List<DVD> DVDLibrary) //or should it be displayDVDLibrary ?
    {
        for (DVD : dvdList)
        {
            String dvdInfo = String.format("#%s : %s %s",
                    currentDVD.getDvdID();
                    currentDVD.getDvdTitle();
                    currentDVD.getDvdDate());

            io.print(DvdInfo);
        }
        io.readString("Hit enter to continue.");
    }

    //Display DVD info <--Should this go above the display list method?
    public DVD getDvdInfo()
    {
        String title = io.readString("Enter DVD Title:");
        String releaseData = io.readString("Enter DVD Release Date:");
        String mpaaRating = io.readString("Enter MPAA Rating:");
        String director = io.readString("Enter name of Director:");
        String studio = io.readString("Enter Studio:");
        String userRating = io.readString("Enter user rating:");
        
    }

    //Display DVD Banner

    //Display DVD List Banner (All the DVDs that were entered / on the list)

    

}
