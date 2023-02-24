package com.sg.dvdlibrary.dto;

public class DVD {
    private String title;
    private String releaseDate;
    private String mpaaRating;

    private String directorName;
    private String studio;
    private String userRatingOrNote;

    private Collection dvdCollection;

    public DVD (String title){
        this.title = title;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating(){
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRatingOrNote() {
        return userRatingOrNote;
    }

    public void setUserRatingOrNote(String userRatingOrNote) {
        this.userRatingOrNote = userRatingOrNote;
    }

    public Collection getDvdCollection() {
        return dvdCollection;
    }

    public void setDvdCollection(Collection dvdCollection) {
        this.dvdCollection = dvdCollection;
    }

}
