package dvdlibrary.controller;

import dvdlibrary.dao.DvdLibraryDao;
import dvdlibrary.dao.DvdLibraryDaoException;
import dvdlibrary.dao.DvdLibraryDaoFileImpl;
import dvdlibrary.dto.Dvd;
import dvdlibrary.ui.DvdLibraryView;
import java.io.IOException;
import java.util.List;

/**
 *
 * Program that will be the controller allow users to enter, store, recall and
 * edit information about their DVD library
 */
public class DvdLibraryController
    {

    // Model and VIew class objects
    private DvdLibraryView view = new DvdLibraryView();
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    // Function that controls program flow
    public void run()
        {
        boolean keepGoing = true;
        int menuSelection = 0;

        try
            {
            while (keepGoing)
                {
                menuSelection = getMenuSelection();
                switch (menuSelection)
                    {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd(); 
                        break;
                    case 6:
                        searchDvdTitle(); 
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    case 8:
                        searchDvdsByLastNYearsRelease();
                        break;
                    case 9:
                        searchDvdsByMpaa();
                        break;
                    case 10:
                        searchDvdsByDirector();
                        break;  
                    default:
                        unknownCommand();
                    }
                }
            } catch (DvdLibraryDaoException e)
            {
            System.out.println(e.getMessage());
            
            }
        exitMessage();
        }
    // Let's user know they've exited
    private void exitMessage()
        {
        view.displayExitBanner();
        }
    // Prompts user for a known command
    private void unknownCommand()
        {
        view.displayUnknownCommandBanner();
        }
    // Requests view to display the menu
    private int getMenuSelection()
        {
        return view.getMenuSelection();
        }
    // Adds a dvd to collection
    private void addDvd() throws DvdLibraryDaoException
        {
        view.displayAddDvdBanner();
        Dvd dvd = view.getDvdInfo();
        dao.addDvd(dvd.getId(), dvd);
        view.displayAddDvdSuccessBanner();
        }
    // removes a dvd from the collection
    private void removeDvd() throws DvdLibraryDaoException
        {
        view.displayRemoveDvdBanner();
        String dvdId = view.getDvdId();
        dao.removeDvd(dvdId);
        view.displayRemoveDvdSuccessBanner();
        }
    // Function for editing a dvd
    private void editDvd() throws DvdLibraryDaoException
        {
        view.displayEditDvdBanner();
        String dvdId = view.getDvdId();
        Dvd currentDvdInfo = dao.getDvd(dvdId);
        view.displayDvdInfo(currentDvdInfo);
        Dvd newDvdInfo = view.getDvdInfo();
        dao.addDvd(dvdId, newDvdInfo);
        view.displayEditDvdSuccessBanner();
        }
    // lists all dvd in the collection
    private void listDvds() throws DvdLibraryDaoException
        {
        view.displayListDvdsBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
        }
    // views a dvd by dvdID
    private void viewDvd() throws DvdLibraryDaoException
        {
        view.displayViewDvdBanner();
        String dvdId = view.getDvdId();
        Dvd dvd = dao.getDvd(dvdId);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
        }
    // views a dvd by title
    private void searchDvdTitle() throws DvdLibraryDaoException
    {
        view.displaySearchDvdBanner();
        String dvdTitle = view.getDvdTitle();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();    
    }
    
    /**
     *  Finds all movies released within the last N years
     */
    private void searchDvdsByLastNYearsRelease() throws DvdLibraryDaoException{
        view.displaySearchByNYearsBanner();
        String yearRange = view.getNYears();
        List<Dvd> dvdList = dao.releasedInNYears(Integer.parseInt(yearRange));
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }
    
    /**
     * Finds all movies with a given MPAA rating 
     */
    private void searchDvdsByMpaa() throws DvdLibraryDaoException{
        view.displaySearchByMpaaRatingsBanner();
        String mpaaRating = view.getSearchByMpaaRating();
        List<Dvd> dvdList = dao.displayByRating(mpaaRating);
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }
    
    /**
     * Finds all movies by a certain director
     */
    private void searchDvdsByDirector() throws DvdLibraryDaoException{
        view.displaySearchByDirectorBanner();
        String director = view.getSearchByDirector();
        List<Dvd> dvdList = dao.displayByDirector(director);
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }
    
}
