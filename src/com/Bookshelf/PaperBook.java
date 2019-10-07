package com.Bookshelf;

import java.util.Comparator;

public class PaperBook extends Book{

    //Variables for PaperBook only
    private String pages;

    //Constructor for PaperBook
    public PaperBook (String name, int year, String author, float stars, String pages){
        super (name, year, author, stars);
        this.pages = pages;

    }

    public PaperBook(String name, int year, String author, float stars) {
        super(name, year, author, stars);
    }


    //Getter for PaperBook
    public String getPages() {
        return pages;
    }

    @Override
    public float getStars() {
        return super.getStars();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    //Method for creating PaperBook
    public static PaperBook createBook (String name, int year, String author, float stars, String pages){
        return new PaperBook(name, year, author, stars, pages);}

    public String ToString(){
        return "Rating: " + getStars() + " - Book: " + getName();
    }

}

//Class to sort books via Comparator
class PaperBookSort implements Comparator<PaperBook> {
    public int compare(PaperBook b1, PaperBook b2) {
        return Float.compare(b1.getStars(), b2.getStars());
    }

}