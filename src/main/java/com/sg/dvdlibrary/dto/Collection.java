package com.sg.dvdlibrary.dto;

public class Collection {
  private String owner;
  private String collectionName;
  private String releaseDate;
  private String genre;

  public Collection(String collectionName){
      this.collectionName = collectionName;
  }

  public String getCollectionName(){
      return collectionName;
  }

    public String setCollectionName(String collectionName){
        return this.collectionName = collectionName;
    }

    public String getOwner(){
        return owner;
    }

    public String setOwner(String owner){
        return this.owner = owner;
    }

    public String getReleaseDate(){
        return releaseDate;
    }

    public String setReleaseDate(String releaseDate){
        return this.releaseDate = releaseDate;
    }

    public String getGenre(){
        return genre;
    }

    public String setGenre(String genre){
        return this.genre = genre;
    }
}
