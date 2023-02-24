package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;

import java.util.List;

public interface DVDLibraryDao {
    /**
     * Creates a new DVD and adds it to our library
     * @param title
     * @param dvd
     * @return
     * @throws DVDLibraryDaoException
     */
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;

    /**
     * Removes an existing DVD from our library
     * @param title
     * @return
     * @throws DVDLibraryDaoException
     */
    DVD removeDVD(String title) throws DVDLibraryDaoException;

    /**
     * Edits an Existing DVD in our library
     * @param title
     * @param field
     * @param value
     * @return
     * @throws DVDLibraryDaoException
     */
    DVD editDVD(String title, int field, String value) throws DVDLibraryDaoException;

    /**
     * Gets all existing DVDs in our library
     * @return
     * @throws DVDLibraryDaoException
     */
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    /**
     * Gets an existing DVD in our library
     * @param title
     * @return
     * @throws DVDLibraryDaoException
     */
    DVD getDVD(String title) throws DVDLibraryDaoException;




}
