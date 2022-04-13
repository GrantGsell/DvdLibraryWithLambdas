package dvdlibrary;

import dvdlibrary.controller.DvdLibraryController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Grant
 */
public class DvdLibrary {

    public static void main(String[] args) {
        // Dependendcy Injection using Spring Annotations
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("dvdlibrary");
        appContext.refresh();
       
        DvdLibraryController controller = appContext.getBean("dvdLibraryController", DvdLibraryController.class);
        controller.run();
        
        
        //DvdLibraryController controller = new DvdLibraryController();
        //controller.run();
    }
}
