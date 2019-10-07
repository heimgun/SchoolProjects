package com.Bookshelf;

import java.util.ArrayList;
import java.util.Collections;

public class BookshelfPaper{

        private ArrayList<PaperBook> myPaperBooks;


        //Constructor
        public BookshelfPaper() {
            this.myPaperBooks = new ArrayList<PaperBook>();
        }



        //Method for searching if book is in shelf, otherwise adding book to shelf
        public boolean addNewBook(PaperBook book) {
            if (findBook(book.getName()) >= 0) {
                System.out.println("The book is already in the Shelf");
                return false;
            }
            myPaperBooks.add(book);
            return true;
        }

        //Returns position of book
        private int findBook(PaperBook book) {
            return this.myPaperBooks.indexOf(book);
        }

        //Method for getting a certain books "place" (int) in the Arraylist by using the books name (string)
        private int findBook(String bookName) {
            for (int i = 0; i < this.myPaperBooks.size(); i++) {
                Book book = this.myPaperBooks.get(i);
                if (book.getName().equals(bookName)) {
                    return i;
                }
            }
            return -1;
        }

        /*
        Method for removing a book from the ArrayList by using findBook(), if the book has a place in the list (its number is
        above 0), the book will be removed from the list. If it does not have a number above 0, it is not in the list, and cannot
        be found.
         */
        public boolean removeBook(PaperBook book) {
            int foundPosition = findBook(book);
            if (foundPosition < 0) {
                System.out.println(book.getName() + " could not be found in Shelf.");
                return false;
            }
            this.myPaperBooks.remove(foundPosition);
            System.out.println(book.getName() + " has been removed from Shelf.");
            return true;
        }

        //Method for printing objects in the Arraylist, from first added to last, with the mentioned variables values
        public void printShelf() {
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

        public String queBook(PaperBook book) {
            if (findBook(book) >= 0) {
                return book.getName();
            }
            return null;
        }

        public PaperBook queBook(String name) {
            int position = findBook(name);
            if (position >= 0) {
                return (PaperBook) this.myPaperBooks.get(position);
            }

            return null;
        }

    public String queBookYear(PaperBook yearx) {
        if (findBook(yearx) >= 0) {
            return yearx.getYear();
        }
        return null;
    }

    public PaperBook queBookYear(String yearx) {
        int position = findBook(yearx);
        if (position >= 0) {
            return (PaperBook) this.myPaperBooks.get(position);
        }

        return null;
    }

        //Get book with highest rating
        public void paperSort(){
            Collections.sort(myPaperBooks, new PaperBookSort());
            for(PaperBook a : myPaperBooks){
                System.out.println(a.ToString());
            }
    }






        //Get random book

}









