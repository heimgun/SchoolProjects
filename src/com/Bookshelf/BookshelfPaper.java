package com.Bookshelf;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Arraylist for PaperBook - class
 *
 */
public class BookshelfPaper{

    private ArrayList<PaperBook> myPaperBooks;


    /**
     * Constructor for Arraylist
     */
    public BookshelfPaper() {
            this.myPaperBooks = new ArrayList<PaperBook>();
        }



    /**
     * This is the Method for adding a new book to the Arraylist
     *
     * @param book in Main to figure out whether or not the name of the book already exists in Arraylist
     * @return adds book if not in Arraylist, uses method in Main to do so
     */
    public boolean addNewBook(PaperBook book) {
        if (findBook(book.getName()) >= 0) {
            System.out.println("The book is already in the Shelf");
            return false;
        }
        myPaperBooks.add(book);
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
    public boolean removeBook(PaperBook book) {
        int foundPosition = findBook(book);
            if (foundPosition < 0) {
                System.out.println(book.getName() + " could not be found in Shelf.");
                return false;
            }
            this.myPaperBooks.remove(foundPosition);
            System.out.println("You have borrowed " + book.getName());
            return true;
        }

    /**
     * printShelf() prints all current Objects in Arraylist.
     * It prints all values of variables in PaperBook.
     */
    public void printShelf() {
        System.out.println();
        System.out.println("Current Bookshelf:");
            if (myPaperBooks.size()>0) {
                for (int i = 0; i < myPaperBooks.size(); i++) {
                    System.out.println(this.myPaperBooks.get(i).getName() + " by " + this.myPaperBooks.get(i).getAuthor() + "\nYear: " + this.myPaperBooks.get(i).getYear() + " - Pages: " + this.myPaperBooks.get(i).getPages() + "\nStars: " + this.myPaperBooks.get(i).getStars());
                    System.out.println();
                }
            } else if (myPaperBooks.size()<=0){
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
        for (int i = 0; i < this.myPaperBooks.size(); i++) {
            Book book = this.myPaperBooks.get(i);
            if (book.getName().equals(bookName)) {
                return i;
            }
        }
        return -1;
    }

    private int findBook(PaperBook book) {
        return this.myPaperBooks.indexOf(book);
    }

    /**
     * Method saves information in AudioBook based upon user input
     * Uses method findBook(String)
     *
     * @param name
     * @return stores information if above or the same as 0, returns null if not
     */
    public PaperBook queBook(String name) {
        int position = findBook(name);
            if (position >= 0) {
                return (PaperBook) this.myPaperBooks.get(position);
            }

            return null;
    }

    /**
     * Method prints all Objects in ArrayList with name based on getName()
     * prints method ToString() in PaperBook
     *
     * @param name
     */
    public void printTitle(String name) {
        for (PaperBook d : myPaperBooks) {
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
        for (int i = 0; i < this.myPaperBooks.size(); i++) {
            Book book = this.myPaperBooks.get(i);
            if (book.getAuthor().equals(author)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method saves information in PaperBook based upon user input
     * Uses method findAuthor
     *
     * @param name
     * @return stores information if above or the same as 0, returns null if not
     */
    public PaperBook queAuthor(String name) {
        int position = findAuthor(name);
        if (position >= 0) {
            return (PaperBook) this.myPaperBooks.get(position);
        }

        return null;
    }

    /**
     * Method prints all Objects in ArrayList with name based on getAuthor()
     * prints method ToString() in PaperBook
     *
     * @param author
     */
    public void printAuthor(String author) {
        for (PaperBook d : myPaperBooks) {
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
        for (int i = 0; i < this.myPaperBooks.size(); i++) {
            Book book = this.myPaperBooks.get(i);
            if (book.getYear() == yearX) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method saves information in PaperBook based upon user input
     * Uses method findBook(int)
     *
     * @param yearX
     * @return stores information if above or the same as 0, returns null if not
     */
    public PaperBook queBookYear(int yearX) {
        int position = findBook(yearX);
        if (position >= 0) {
            return (PaperBook) this.myPaperBooks.get(position);
        }
        return null;
    }

    /**
     * Method prints all Objects in ArrayList with yearX based on getYear()
     * prints method ToString() in PaperBook
     *
     * @param yearX
     */
    public void printYear(int yearX) {
        for (PaperBook d : myPaperBooks) {
            if (d.getYear() >= 0 && d.getYear() == (yearX)) {
                System.out.println(d.ToString());
            }
        }

    }

    /**
     * This method uses Comparator PaperBookSort - Class
     * Which is found underneath the PaperBook - Class
     * This method sorts all "comparisons" and prints ToString()
     */
    public void paperSort(){
        System.out.println();
        System.out.println("Top books by critics:");
        Collections.sort(myPaperBooks, new PaperBookSort());
            for(PaperBook a : myPaperBooks){
                System.out.println(a.ToString());
            }
    }




}









