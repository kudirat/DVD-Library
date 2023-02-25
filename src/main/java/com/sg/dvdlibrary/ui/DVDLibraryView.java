package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Collection;
import com.sg.dvdlibrary.dto.DVD;

import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add New DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List Current DVDs");
        io.print("5. Display DVD Information");
        io.print("6. Exit");


        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo(){
        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter DVD release Date. In this format: MM/YYYY");
        String mpaaRating = io.readString("Please enter DVD MPAA rating");
        String directorName = io.readString("Please enter DVD Director's Name");
        String studio = io.readString("Please enter DVDs studio");
        String userRatingorNote = io.readString("Please enter your rating or notes for this DVD");
        String collectionName = io.readString("Please enter the name of the Collection this DVD belongs to");

        DVD currDVD = new DVD(title);
        currDVD.setReleaseDate(releaseDate);
        currDVD.setMpaaRating(mpaaRating);
        currDVD.setDirectorName(directorName);
        currDVD.setStudio(studio);
        currDVD.setUserRatingOrNote(userRatingorNote);
        //create a new Collection object that we can set for our DVD
        Collection dvdCollection = new Collection(collectionName);
        currDVD.setDvdCollection(dvdCollection);
        return currDVD;
    }

    public void displayCreateDVDBanner(){
        io.print("=== CREATE DVD ===");
    }

    public void displayCreateDVDSuccessBanner(){
        io.readString(
                "DVD Successfully created. Please hit enter to continue."
        );
    }

    public void displayDVDList(List<DVD> dvdList){
        for(DVD currDVD : dvdList){
            String dvdInfo = String.format("#%s : %s %s %s %s %s %s",
                    currDVD.getTitle(),
                    currDVD.getReleaseDate(),
                    currDVD.getMpaaRating(),
                    currDVD.getDirectorName(),
                    currDVD.getStudio(),
                    currDVD.getUserRatingOrNote(),
                    currDVD.getDvdCollection());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDisplayAllBanner(){
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner(){
        io.print("=== Display DVD ===");
    }

    public String getDVDTitle(){
        return io.readString("Please enter the DVD title");
    }

    public void displayDVD(DVD dvd){
        if(dvd != null){
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRatingOrNote());
            io.print(dvd.getDvdCollection());
        }
        else{
            displayErrorMessage("This DVD doesn't exist");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayRemoveDVDBanner(){
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD currDVD){
        if(currDVD != null){
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD exists.");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayEditDVDBanner(){
        io.print("=== EDIT DVD ===");
    }

    public void displayEditDVDSuccessBanner(){
        io.readString(
                "DVD Successfully edited. Please hit enter to continue."
        );
    }
    public int printEditMenuAndGetSelection() {
        io.print("Edit DVD Menu");
        io.print("1. Edit Release Date");
        io.print("2. Edit MPAA Rating");
        io.print("3. Edit Director's Name");
        io.print("4. Edit Studio");
        io.print("5. Edit User Rating or Note");
        io.print("6. Edit Collection");
        io.print("7. Exit to Main Menu");


        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public String getDVDUpdatedInfo(){
        return io.readString("Please enter the updated information");
    }

    public void displayExitBanner(){
            io.print("GoodBye!!!!");
    }

    public void displayUnknownCommandBanner(){
        io.print("This is an Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
