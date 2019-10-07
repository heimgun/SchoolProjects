package com.Bookshelf;

import java.util.Comparator;

public class AudioBook extends Book {

    //Variables for AudioBook
    private String minutes;

    //Constructor for AudioBook
    public AudioBook (String name, int year, String author, float stars, String minutes){
        super (name, year, author, stars);
        this.minutes = minutes;

    }

    public AudioBook(String name, int year, String author, float stars) {
        super(name, year, author, stars);
    }

    @Override
    public float getStars() {
        return super.getStars();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    //Getter for AudioBook
    public String getMinutes() {
        return minutes;
    }

    //Method for creating AudioBook
    public static AudioBook createBook (String name, int year, String author, float stars, String minutes){
        return new AudioBook(name, year, author, stars, minutes);}

    public String ToString(){
        return "Rating: " + getStars() + " - Book: " + getName();
    }

}

//Class to sort books via Comparator
class AudioBookSort implements Comparator<AudioBook> {
    public int compare(AudioBook b1, AudioBook b2) {
        return Float.compare(b1.getStars(), b2.getStars());
    }
}
