package dvdlibrary.dto;

/**
 *
 * @author Full Team
 */
public class Dvd {
    // DVD Fields
    String title;
    String releaseData;
    String mpaaRating;
    String director;
    String studio;
    String userRating;
    String dvdId;
    
    // DVD Constructor
    
    
    // DVD Getters
    public String getId(){
        return dvdId;
    }
    
    public String getTitle() {
        return title;
    }

    public String getReleaseData() {
        return releaseData;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public String getUserRating() {
        return userRating;
    }

    // DVD Setters
    public void setId(String dvdId){
        this.dvdId = dvdId;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    
}
