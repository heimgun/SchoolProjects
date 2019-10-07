package com.Bookshelf;

public class Book {

    //Variables for superclass Book
    private String name;
    private int year;
    private String author;
    private float stars;

    //Constructor
    public Book(String name, int year, String author, float stars){
        this.name = name;
        this.year = year;
        this.author = author;
        this.stars = stars;
    }

    //Getters for Book
    public String getName() {return name;}
    public int getYear() {return year;}
    public String getAuthor() {return author;}
    public float getStars() { return stars; }


}
