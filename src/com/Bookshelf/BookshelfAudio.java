package com.Bookshelf;

import java.util.ArrayList;
import java.util.Collections;

public class BookshelfAudio {

    private ArrayList<AudioBook> myAudioBooks;

    //Konstruktor
    public BookshelfAudio() {
        this.myAudioBooks = new ArrayList<AudioBook>();
    }

    public boolean addNewBook(AudioBook book) {
        if (findBook(book.getName()) >= 0) {
            System.out.println("The book is already in the Shelf");
            return false;
        }
        myAudioBooks.add(book);
        return true;
    }

    private int findBook(AudioBook book) {
        return this.myAudioBooks.indexOf(book);
    }



    public boolean removeBook(AudioBook book) {
        int foundPosition = findBook(book);
        if (foundPosition < 0) {
            System.out.println(book.getName() + " could not be found in Shelf.");
            return false;
        }
        this.myAudioBooks.remove(foundPosition);
        System.out.println(book.getName() + " has been removed from Shelf.");
        return true;
    }


    public void printShelf() {
        System.out.println("Current Bookshelf:");
        if (myAudioBooks.size() > 0) {
            for (int i = 0; i < myAudioBooks.size(); i++) {
                System.out.println(this.myAudioBooks.get(i).getName() + " by " + this.myAudioBooks.get(i).getAuthor() + "\nYear: " + this.myAudioBooks.get(i).getYear() + " - Minutes: " + this.myAudioBooks.get(i).getMinutes() + "\nStars: " + this.myAudioBooks.get(i).getStars());
                System.out.println();
            }
        } else if (myAudioBooks.size() <= 0) {
            System.out.println("Bookshelf is currently empty");
        }
    }

    //SEARCH FOR NAME(TITLE)
    private int findBook(String bookName) {
        for (int i = 0; i < this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if (book.getName().equals(bookName)) {
                return i;
            }
        }
        return -1;
    }

    public AudioBook queBook(String name) {
        int position = findBook(name);
        if (position >= 0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }

        return null;
    }

    public void printTitle(String name) {
        for (AudioBook d : myAudioBooks) {
            if (((d.getName() != null) && (d.getName().equals(name)))) {
                System.out.println(d.ToString());
            }
        }

    }



    //SEARCH FOR AUTHOR
    private int findAuthor(String author) {
        for (int i = 0; i < this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if (book.getAuthor().equals(author)) {
                return i;
            }
        }
        return -1;
    }

    public AudioBook queAuthor(String name) {
        int position = findAuthor(name);
        if (position >= 0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }

        return null;
    }


    public void printAuthor(String author) {
        for (AudioBook d : myAudioBooks) {
            if ((d.getAuthor() != null) && (d.getAuthor().equals(author))) {
                System.out.println(d.ToString());
            }
        }

    }


    //SEARCH FOR YEAR
    private int findBook(int yearX) {
        for (int i = 0; i < this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if (book.getYear() == yearX) {
                return i;
            }
        }
        return -1;
    }


    public AudioBook queBookYear(int yearX) {
        int position = findBook(yearX);
        if (position >= 0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }
        return null;
    }


    public void printYear(int yearX) {
        for (AudioBook d : myAudioBooks) {
            if (d.getYear() >= 0 && d.getYear() == (yearX)) {
                System.out.println(d.ToString());
            }
        }

    }



    //Method for sorting books by rating
    public void audioSort() {
        Collections.sort(myAudioBooks, new AudioBookSort());
        for (AudioBook a: myAudioBooks) {
            System.out.println(a.ToString());
        }

    }
}
