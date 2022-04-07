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

    // Loop that handles the menuselection
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
                    default:
                        unknownCommand();
                    }
                }
            } catch (DvdLibraryDaoException e)
            {
            System.out.println(e.getMessage());
            //view.print(e.getMessage());
            }
        exitMessage();
        }

    private void exitMessage()
        {
        view.displayExitBanner();
        }

    private void unknownCommand()
        {
        view.displayUnknownCommandBanner();
        }

    private int getMenuSelection()
        {
        return view.getMenuSelection();
        }

    private void addDvd() throws DvdLibraryDaoException
        {
        view.displayAddDvdBanner();
        Dvd dvd = view.getDvdInfo();
        dao.addDvd(dvd.getId(), dvd);
        view.displayAddDvdSuccessBanner();
        }

    private void removeDvd() throws DvdLibraryDaoException
        {
        view.displayRemoveDvdBanner();
        String dvdId = view.getDvdId();
        dao.removeDvd(dvdId);
        view.displayRemoveDvdSuccessBanner();
        }

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

    private void listDvds() throws DvdLibraryDaoException
        {
        view.displayListDvdsBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
        }

    private void viewDvd() throws DvdLibraryDaoException
        {
        view.displayViewDvdBanner();
        String dvdId = view.getDvdId();
        Dvd dvd = dao.getDvd(dvdId);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
        }

    private void searchDvdTitle() throws DvdLibraryDaoException
        {
        view.displaySearchDvdBanner();
        String dvdTitle = view.getDvdTitle();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
        }

    }
