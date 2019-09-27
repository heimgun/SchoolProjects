package com.Bookshelf;

public class PaperBook extends Book{

    private String pages;

    public PaperBook (String name, String year, String author, String pages){
        super (name, year, author);
        this.pages = pages;

    }

    public PaperBook(String name, String year, String author) {
        super(name, year, author);
    }

    public String getPages() {
        return pages;
    }

    public static PaperBook createBook (String name, String year, String author, String pages){
        return new PaperBook(name, year, author, pages);}


}
