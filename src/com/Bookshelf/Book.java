package com.Bookshelf;

public class Book {

    private String name;
    private String year;
    private String author;

    //Konstruktor
    public Book(String name, String year, String author){
        this.name = name;
        this.year = year;
        this.author = author;
    }

    //Getters for Book
    public String getName() {return name;}
    public String getYear() {return year;}
    public String getAuthor() {return author;}


    public static Book createBook (String name, String year, String author){
       return new Book(name, year, author);
    }
}
