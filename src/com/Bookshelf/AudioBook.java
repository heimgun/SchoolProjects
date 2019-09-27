package com.Bookshelf;

public class AudioBook extends Book {

    //Definer variabler for AudioBook
    private String minutes;

    public AudioBook (String name, String year, String author, String minutes){
        super (name, year, author);
        this.minutes = minutes;

    }

    public AudioBook(String name, String year, String author) {
        super(name, year, author);
    }

    public String getMinutes() {
        return minutes;
    }

    public static AudioBook createBook (String name, String year, String author, String minutes){
        return new AudioBook(name, year, author, minutes);}
}
