package dvdlibrary.controller;

import dvdlibrary.dao.DvdLibraryDao;
import dvdlibrary.dao.DvdLibraryDaoException;
import dvdlibrary.dto.Dvd;
import dvdlibrary.ui.DvdLibraryView;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Program that will be the controller allow users to enter, store, recall and
 * edit information about their DVD library
 */
@Component
public class DvdLibraryController {

    // Model and VIew class objects
    private DvdLibraryView view;
    private DvdLibraryDao dao; 
    
    // Controller Constructor for Dependency Injection
    @Autowired
    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao){
        this.view = view;
        this.dao = dao;
    }

    // Function that controls program flow
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
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
                        searchDvdsByLastNYearsRelease();
                        break;
                    case 8:
                        searchDvdsByMpaa();
                        break;
                    case 9:
                        searchDvdsByDirector();
                        break;
                    case 15:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        } catch (DvdLibraryDaoException e) {
            System.out.println(e.getMessage());

        }
        exitMessage();
    }

    // Let's user know they've exited
    private void exitMessage() {
        view.displayExitBanner();
    }

    // Prompts user for a known command
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    // Requests view to display the menu
    private int getMenuSelection() {
        return view.getMenuSelection();
    }

    // Adds a dvd to collection
    private void addDvd() throws DvdLibraryDaoException {
        view.displayAddDvdBanner();
        Dvd dvd = view.getDvdInfo();
        dao.addDvd(dvd.getId(), dvd);
        view.displayAddDvdSuccessBanner();
    }

    // removes a dvd from the collection
    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdId = view.getDvdId();
        dao.removeDvd(dvdId);
        view.displayRemoveDvdSuccessBanner();
    }

    // Function for editing a dvd
    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String dvdId = view.getDvdId();
        Dvd currentDvdInfo = dao.getDvd(dvdId);
        view.displayDvdInfo(currentDvdInfo);
        Dvd newDvdInfo = view.getDvdInfo();
        dao.addDvd(dvdId, newDvdInfo);
        view.displayEditDvdSuccessBanner();
    }

    // lists all dvd in the collection
    private void listDvds() throws DvdLibraryDaoException {
        view.displayListDvdsBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }

    // views a dvd by dvdID
    private void viewDvd() throws DvdLibraryDaoException {
        view.displayViewDvdBanner();
        String dvdId = view.getDvdId();
        Dvd dvd = dao.getDvd(dvdId);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
    }

    // views a dvd by title
    private void searchDvdTitle() throws DvdLibraryDaoException {
        view.displaySearchDvdBanner();
        String dvdTitle = view.getDvdTitle();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
    }

    /**
     * Finds all movies released within the last N years
     */
    private void searchDvdsByLastNYearsRelease() throws DvdLibraryDaoException {
        view.displaySearchByNYearsBanner();
        String yearRange = view.getNYears();
        List<Dvd> dvdList = dao.releasedInNYears(Integer.parseInt(yearRange));
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }

    /**
     * Finds all movies with a given MPAA rating
     */
    private void searchDvdsByMpaa() throws DvdLibraryDaoException {
        view.displaySearchByMpaaRatingsBanner();
        String mpaaRating = view.getSearchByMpaaRating();
        List<Dvd> dvdList = dao.displayByRating(mpaaRating);
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }

    /**
     * Finds all movies by a certain director
     */
    private void searchDvdsByDirector() throws DvdLibraryDaoException {
        view.displaySearchByDirectorBanner();
        String director = view.getSearchByDirector();
        Map<String, List<Dvd>> dvdList = dao.displayByDirector(director);
        view.printByDirector(dvdList);
        view.displayEditDvdSuccessBanner();
    }

    private void searchDvdsByStudio() throws DvdLibraryDaoException {
        view.displayByStudioBanner();
        String studio = view.searchByStudio();
        List<Dvd> dvdList = dao.displayByStudio(studio);
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }
    
    private void findAverageAge() throws DvdLibraryDaoException {
        view.displayAverageAgeBanner();
        Double averageAge = dao.displayAverageAgeOfMovies();
        view.displayAverageAge(averageAge);
        view.displayEditDvdSuccessBanner();
    }

}
