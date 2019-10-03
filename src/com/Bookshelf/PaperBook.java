package com.Bookshelf;

public class PaperBook extends Book{

    //Variables for PaperBook only
    private String pages;

    //Constructor for PaperBook
    public PaperBook (String name, String year, String author, String pages){
        super (name, year, author);
        this.pages = pages;

    }

    public PaperBook(String name, String year, String author) {
        super(name, year, author);
    }

    //Getter for PaperBook
    public String getPages() {
        return pages;
    }

    //Method for creating PaperBook
    public static PaperBook createBook (String name, String year, String author, String pages){
        return new PaperBook(name, year, author, pages);}


}
