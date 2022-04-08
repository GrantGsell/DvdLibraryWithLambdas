package dvdlibrary.dto;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.releaseData);
        hash = 73 * hash + Objects.hashCode(this.mpaaRating);
        hash = 73 * hash + Objects.hashCode(this.director);
        hash = 73 * hash + Objects.hashCode(this.studio);
        hash = 73 * hash + Objects.hashCode(this.userRating);
        hash = 73 * hash + Objects.hashCode(this.dvdId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseData, other.releaseData)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        return Objects.equals(this.dvdId, other.dvdId);
    }

    @Override
    public String toString() {
        return "Dvd{" + "title=" + title + ", releaseData=" + releaseData + ", mpaaRating=" + mpaaRating + ", director=" + director + ", studio=" + studio + ", userRating=" + userRating + ", dvdId=" + dvdId + '}';
    }
            
}
