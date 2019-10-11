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

    //Getter for AudioBook
    @Override
    public float getStars() {
        return super.getStars();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getYear() { return super.getYear(); }

    public String getMinutes() {
        return minutes;
    }


    //Method for creating AudioBook
    public static AudioBook createBook (String name, int year, String author, float stars, String minutes){
        return new AudioBook(name, year, author, stars, minutes);}

    public String ToString(){
        return "Book: " + getName() + " - Rating: " + getStars();
    }

}

    /**
    * This is a class which compares two objects in AudioBook based upon getStars()
    * It is used in the Arraylist to get sorted
    */
    class AudioBookSort implements Comparator<AudioBook> {
    public int compare(AudioBook b1, AudioBook b2) {
        return Float.compare(b2.getStars(), b1.getStars());
    }
}
