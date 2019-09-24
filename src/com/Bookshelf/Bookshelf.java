package com.Bookshelf;

import java.util.ArrayList;

public class Bookshelf {

    private ArrayList<Book> myBooks;

    //Konstruktor
    public Bookshelf(){
        this.myBooks = new ArrayList<Book>();
    }

    public boolean addNewBook(Book book){
        if(findBook(book.getName()) >= 0){
            System.out.println("The book is already in the Shelf");
            return false;
        }
        myBooks.add(book);
        return true;
    }

    private int findBook(Book book) {
        return this.myBooks.indexOf(book);
    }

    private int findBook(String bookName) {
        for(int i=0; i<this.myBooks.size(); i++) {
            Book book = this.myBooks.get(i);
            if(book.getName().equals(bookName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeBook(Book book) {
        int foundPosition = findBook(book);
        if(foundPosition <0) {
            System.out.println(book.getName() +" could not be found in Shelf.");
            return false;
        }
        this.myBooks.remove(foundPosition);
        System.out.println(book.getName() + " has been removed from Shelf.");
        return true;
    }






    public void printShelf(){
        System.out.println("Current Bookshelf:");
        for (int i=0;i<myBooks.size();i++){
            System.out.println(this.myBooks.get(i).getName() + " by " + this.myBooks.get(i).getAuthor() + "\nYear: " + this.myBooks.get(i).getYear());
            System.out.println();
        }
    }

    public String queBook(Book book) {
        if(findBook(book) >=0) {
            return book.getName();
        }
        return null;
    }

    public Book queBook(String name) { // (Vi returnerar Contact (ett objekt))
        int position = findBook(name);
        if(position >=0) {
            return this.myBooks.get(position);
        }

        return null;
    }
}
