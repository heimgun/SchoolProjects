package com.Bookshelf;

public class AudioBook extends Book {

    //Variables for AudioBook
    private String minutes;

    //Constructor for AudioBook
    public AudioBook (String name, String year, String author, String minutes){
        super (name, year, author);
        this.minutes = minutes;

    }

    public AudioBook(String name, String year, String author) {
        super(name, year, author);
    }

    //Getter for AudioBook
    public String getMinutes() {
        return minutes;
    }

    //Method for creating AudioBook
    public static AudioBook createBook (String name, String year, String author, String minutes){
        return new AudioBook(name, year, author, minutes);}
}
