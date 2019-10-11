package com.Bookshelf;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Arraylist for AudioBook - class
 *
 */
public class BookshelfAudio {

    private ArrayList<AudioBook> myAudioBooks;

    /**
     * Constructor for Arraylist
     */
    public BookshelfAudio() {
        this.myAudioBooks = new ArrayList<AudioBook>();
    }

    /**
     * This is the Method for adding a new book to the Arraylist
     *
     * @param book in Main to figure out whether or not the name of the book already exists in Arraylist
     * @return adds book if not in Arraylist
     */
    public boolean addNewBook(AudioBook book) {
        if (findBook(book.getName()) >= 0) {
            System.out.println("The book is already in the Shelf");
            return false;
        }
        myAudioBooks.add(book);
        return true;
    }



    /**
     * This method is used in user - option "Borrow book".
     * The method searches if the named parameter is in the Arraylist, and removes it from
     * "the Library" if it is
     *
     * @param book from Main
     * @return removes book
     */
    public boolean removeBook(AudioBook book) {
        int foundPosition = findBook(book);
        if (foundPosition < 0) {
            System.out.println(book.getName() + " could not be found in Shelf.");
            return false;
        }
        this.myAudioBooks.remove(foundPosition);
        System.out.println("You have borrowed " + book.getName());
        return true;
    }


    /**
     * printShelf() prints all current Objects in Arraylist.
     * It prints all values of variables in AudioBook.
     */
    public void printShelf() {
        System.out.println();
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

    /**
     * findBook() uses getter for name and user input bookName to figure out if there is a
     * match between the two
     *
     * @param bookName from Main
     * @return place in Arraylist
     */
    private int findBook(String bookName) {
        for (int i = 0; i < this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if (book.getName().equals(bookName)) {
                return i;
            }
        }
        return -1;
    }

    private int findBook(AudioBook book) {
        return this.myAudioBooks.indexOf(book);
    }

    /**
     * Method saves information in AudioBook based upon user input
     * Uses method findBook(String)
     *
     * @param name
     * @return stores information if above or the same as 0, returns null if not
     */
    public AudioBook queBook(String name) {
        int position = findBook(name);
        if (position >= 0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }

        return null;
    }

    /**
     * Method prints all Objects in ArrayList with name based on getName()
     * prints method ToString() in AudioBook
     *
     * @param name
     */
    public void printTitle(String name) {
        for (AudioBook d : myAudioBooks) {
            if (((d.getName() != null) && (d.getName().equals(name)))) {
                System.out.println(d.ToString());
            }
        }

    }

    /**
     * findAuthor() uses getter for name and user input author to figure out if there is a
     * match between the two
     *
     * @param author from Main
     * @return place in Arraylist
     */
    private int findAuthor(String author) {
        for (int i = 0; i < this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if (book.getAuthor().equals(author)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method saves information in AudioBook based upon user input
     * Uses method findAuthor
     *
     * @param name
     * @return stores information if above or the same as 0, returns null if not
     */
    public AudioBook queAuthor(String name) {
        int position = findAuthor(name);
        if (position >= 0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }

        return null;
    }

    /**
     * Method prints all Objects in ArrayList with name based on getAuthor()
     * prints method ToString() in AudioBook
     *
     * @param author
     */
    public void printAuthor(String author) {
        for (AudioBook d : myAudioBooks) {
            if ((d.getAuthor() != null) && (d.getAuthor().equals(author))) {
                System.out.println(d.ToString());
            }
        }

    }


    /**
     * findBook() uses getter for name and user input yearX to figure out if there is a
     * match between the two
     *
     * @param yearX from Main
     * @return place in Arraylist
     */
    private int findBook(int yearX) {
        for (int i = 0; i < this.myAudioBooks.size(); i++) {
            Book book = this.myAudioBooks.get(i);
            if (book.getYear() == yearX) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method saves information in AudioBook based upon user input
     * Uses method findBook(int)
     *
     * @param yearX
     * @return stores information if above or the same as 0, returns null if not
     */
    public AudioBook queBookYear(int yearX) {
        int position = findBook(yearX);
        if (position >= 0) {
            return (AudioBook) this.myAudioBooks.get(position);
        }
        return null;
    }

    /**
     * Method prints all Objects in ArrayList with yearX based on getYear()
     * prints method ToString() in AudioBook
     *
     * @param yearX
     */
    public void printYear(int yearX) {
        for (AudioBook d : myAudioBooks) {
            if (d.getYear() >= 0 && d.getYear() == (yearX)) {
                System.out.println(d.ToString());
            }
        }

    }


    /**
     * This method uses Comparator AudioBookSort - Class
     * Which is found underneath the AudioBook - Class
     * This method sorts all "comparisons" and prints ToString()
     */
    public void audioSort() {
        System.out.println();
        System.out.println("Top books by critics:");
        Collections.sort(myAudioBooks, new AudioBookSort());
        for (AudioBook a: myAudioBooks) {
            System.out.println(a.ToString());
        }

    }
}
