package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Collection;
import com.sg.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{

    private Map<String, DVD> dvds = new HashMap<String, DVD>();
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editDVD(String title, int menuChoice, String value) throws DVDLibraryDaoException {
        //get the dvd using the title
        DVD currDVD = dvds.get(title);
        loadLibrary();
        //switch statement, find the field to be edited
        switch (menuChoice){
            case 1:
                currDVD.setReleaseDate(value);
                break;
            case 2:
                currDVD.setMpaaRating(value);
                break;
            case 3:
                currDVD.setDirectorName(value);
                break;
            case 4:
                currDVD.setStudio(value);
                break;
            case 5:
                currDVD.setUserRatingOrNote(value);
                break;
        }
        //display dvd with updated information and exit
        dvds.put(currDVD.getTitle(), currDVD);
        writeLibrary();
        return currDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    private DVD unmarshallDVD(String dvdAsText){
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        //the dvd title should be in index 0 of the array.
        String dvdTitle = dvdTokens[0];

        // We can use the title to create a new DVD object
        DVD dvdFromFile = new DVD(dvdTitle);

        // Need to set the additional information for the dvd
        // Index 1 - Release Date
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - MPAA Rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - Director Name
        dvdFromFile.setDirectorName(dvdTokens[3]);

        // Index 4 - Studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - User rating or note
        dvdFromFile.setUserRatingOrNote(dvdTokens[5]);

        // Index 6 - DVD Collection
        //String dvdCollectionStr =  dvdTokens[6];
        Collection dvdCollection = new Collection(dvdTokens[6]);
        dvdFromFile.setDvdCollection(dvdCollection);
        // Return new DVD Object
        return dvdFromFile;
    }

    /**
     * Goes through LIBRARY_FILE and decodes each line into a
     * DVD object by calling the unmarshallDVD method.
     *
     *
     * @throws DVDLibraryDaoException
     */
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        try{
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "Could not load DVD Library data into memory.", e);
        }

        String currentLine;

        DVD currDVD;
        // decodes each line in LIBRARY_FILE into a DVD object
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currDVD = unmarshallDVD(currentLine);

            // Use the title as the map key for our DVD object place in map
            dvds.put(currDVD.getTitle(), currDVD);
        }
        // close scanner
        scanner.close();
    }

    /**
     * Turns a DVD object into a line of text for our file.
     * and concatenate with the DELIMITER
     * @param dvd
     * @return
     */
    private String marshallDVD(DVD dvd){

        // Start with the title and add the other fields
        String dvdAsText = dvd.getTitle() + DELIMITER;

        dvdAsText += dvd.getReleaseDate() + DELIMITER;
        dvdAsText += dvd.getMpaaRating() + DELIMITER;
        dvdAsText += dvd.getDirectorName() + DELIMITER;
        dvdAsText += dvd.getStudio() + DELIMITER;
        dvdAsText += dvd.getUserRatingOrNote() + DELIMITER;
        dvdAsText += dvd.getDvdCollection() + DELIMITER;

        return dvdAsText;
    }

    /**
     * Writes all dvds in the library out to a LIBRARY_FILE.
     *
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibraryDaoException{

        PrintWriter out;

        try{
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));

        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }
        // turn a DVD into a String, and write it to file line by line
        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for(DVD currDVD : dvdList){
            dvdAsText = marshallDVD(currDVD);
            out.println(dvdAsText);
            out.flush();
        }
        // Close
        out.close();
    }

}
