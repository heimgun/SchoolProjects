package com.Bookshelf;

import java.util.ArrayList;

public class BookshelfAudio {

    private ArrayList<AudioBook> myAudioBooks;

    //Konstruktor
    public BookshelfAudio(){
        this.myAudioBooks = new ArrayList<AudioBook>();
    }

    public boolean addNewBook(AudioBook book){
        if(findBook(book.getName()) >= 0){
            System.out.println("The book is already in the Shelf");
            return false;
        }
        myAudioBooks.add(book);
        return true;
    }

    private int findBook(AudioBook book) {
        return this.myAudioBooks.indexOf(book);
    }

    private int findBook(String bookName) {
        for(int i=0; i<this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if(book.getName().equals(bookName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeBook(AudioBook book) {
        int foundPosition = findBook(book);
        if(foundPosition <0) {
            System.out.println(book.getName() +" could not be found in Shelf.");
            return false;
        }
        this.myAudioBooks.remove(foundPosition);
        System.out.println(book.getName() + " has been removed from Shelf.");
        return true;
    }


    public void printShelf(){
        System.out.println("Current Bookshelf:");
        for (int i=0;i<myAudioBooks.size();i++){
            System.out.println(this.myAudioBooks.get(i).getName() + " by " + this.myAudioBooks.get(i).getAuthor() + "\nYear: " + this.myAudioBooks.get(i).getYear() + " - Minutes: " + this.myAudioBooks.get(i).getMinutes());
            System.out.println();
        }
    }

    public String queBook(AudioBook book) {
        if(findBook(book) >=0) {
            return book.getName();
        }
        return null;
    }

    public AudioBook queBook(String name) {
        int position = findBook(name);
        if(position >=0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }

        return null;
    }

    //Metode for tilfeldig utvalgt anbefalning av bok


}
