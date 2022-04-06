package dvdlibrary.controller;

import dvdlibrary.dao.DvdLibraryDao;
import dvdlibrary.dao.DvdLibraryDaoFileImpl;
import dvdlibrary.dto.Dvd;
import dvdlibrary.ui.DvdLibraryView;
import java.util.List;

/**
 *
 * @author Grant
 */
public class DvdLibraryController {

    private DvdLibraryView view = new DvdLibraryView();
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

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
                    viewDvd(); // TBI
                    break;
                case 6:
                    searchDvdTitle(); // TBI
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private int getMenuSelection() {
        view.getMenuSelection();
    }

    private void addDvd() {
        view.displayAddDvdBanner();
        Dvd dvd = view.getDvdInfo();
        dao.addDvd(dvd.getDvdId(), dvd);
        view.displayAddDvdSuccessBanner();
    }

    private void removeDvd() {
        view.displayRemoveDvdBanner();
        String dvdId = view.getDvdId();
        dao.removeDvd(dvdId);
        view.displayRemoveDvdSuccessBanner();
    }

    private void editDvd() {
        view.displayEditDvdBanner();
        String dvdId = view.getDvdId();
        Dvd currentDvdInfo = dao.getDvd(dvdId);
        view.displayDvdInfo(currentDvdInfo);
        Dvd newDvdInfo = view.getDvdInfo();
        dao.addDvd(dvdId, dvd);
        view.displayEditDvdSuccessBanner();
    }

    private void listDvds() { //TBI --- How are we storing the list of dvds? 
        view.displayListDvdsBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
        view.displayEditDvdSuccessBanner();
    }

    private void viewDvd() {
        view.displayViewDvdBanner();
        String dvdId = view.getDvdId();
        Dvd dvd = dao.getDvd(dvdId);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
    }

    private void searchDvdTitle() {
        view.displaySearchDvdBanner();
        String dvdTitle = view.getDvdTitle();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvdInfo(dvd);
        view.displayEditDvdSuccessBanner();
    }

}
