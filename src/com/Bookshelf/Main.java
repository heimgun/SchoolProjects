package com.Bookshelf;

import java.util.Scanner;

public class Main {

    /**
     * Here is the connections we need in the program.
     *  - Scanner to comprehend user input
     *  - An Arraylist for AudioBooks
     *  - An Arraylist for PaperBooks
     */
    private static Scanner scanner = new Scanner(System.in);
    public static BookshelfAudio bookshelf = new BookshelfAudio();
    public static BookshelfPaper bookshelf2 = new BookshelfPaper();

    /**
     * main runs the program and here it is chosen which method to implement based on the users wishes
     * main mainly consists of while and switch to do this.
     *
     * @param args
     */
    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            printWelcome();
            System.out.println("Type answer:");
            int shelfChoice = scanner.nextInt();
            scanner.nextLine();

            switch (shelfChoice) {

                //Case 1 = Audio
                case 1:
                    boolean quit = false;
                    printOptions();

                    //While and Switchcase 1.1
                    while (!quit) {
                        System.out.println("Choose option:");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 0:
                                printOptions();
                                break;
                            case 1:
                                addNewBook();
                                break;
                            case 2:
                                bookshelf.printShelf();
                                break;
                            case 3:
                                removeBook();
                                break;
                            case 4:
                                bookshelf.audioSort();
                                break;
                            case 5:
                                boolean stop = false;
                                searchOptions();

                                //While and Switchcase 1.2
                                while (!stop) {
                                    System.out.println("Choose option:");
                                    int search = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (search) {
                                        case 0:
                                            searchForTitle();
                                            break;
                                        case 1:
                                            searchForAuthor();
                                            break;
                                        case 2:
                                            searchForYear();
                                            break;
                                        case 3:
                                            stop = true;
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                quit = true;
                                break;
                        }
                    }
                    break;

                //Case 2 = Paper
                case 2:
                    boolean quit2 = false;
                    printOptions();

                    //While and Switchcase 2.1
                    while (!quit2) {
                        System.out.println("Choose option:");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 0:
                                printOptions();
                                break;
                            case 1:
                                addNewBook2();
                                break;
                            case 2:
                                bookshelf2.printShelf();
                                break;
                            case 3:
                                removeBook2();
                                break;
                            case 4:
                                bookshelf2.paperSort();
                                break;
                            case 5:
                                boolean stop = false;
                                searchOptions();

                                //While and Switchcase 2.2
                                while (!stop) {
                                    System.out.println("Choose option:");
                                    int search = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (search) {
                                        case 0:
                                            searchForTitle2();
                                            break;
                                        case 1:
                                            searchForAuthor2();
                                            break;
                                        case 2:
                                            searchForYear2();
                                            break;
                                        case 3:
                                            stop = true;
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                quit2 = true;
                                break;
                        }
                    }
                    break;

                //Case 0 = Ends program
                case 0:
                    exit = true;
                    break;
            }
        }


    }

    /*
    Under we have the 3 different "menus" that will appear to the user of the program. Trough these menus the user will
    choose an option based upon an integer scanner will scan into the program and act upon.
     */

    /**
     * First menu
     */
    private static void printWelcome() {
        System.out.println("Welcome to the Library! What section would you like to access?");
        System.out.println("\t 1 - Audiobooks");
        System.out.println("\t 2 - Paperbooks");
        System.out.println();
        System.out.println("\t 0 - Quit Bookshelf");
    }

    /**
     * 2nd menu
     */
    private static void printOptions() {
        System.out.println("Options in Bookshelf:");
        System.out.println("\t 0 - Show options");
        System.out.println("\t 1 - Add book");
        System.out.println("\t 2 - All books");
        System.out.println("\t 3 - Borrow book");
        System.out.println("\t 4 - The best books right now");
        System.out.println("\t 5 - Search for book");
        System.out.println();
        System.out.println("\t 6 - Back to main menu");
    }

    /**
     * 3rd menu
     */
    private static void searchOptions(){
        System.out.println("\t 0 - Search for title");
        System.out.println("\t 1 - Search for author");
        System.out.println("\t 2 - Search for year");
        System.out.println();
        System.out.println("\t 3 - Back to shelf");
    }

    //Methods for AudioBooks:

    /**
     * This is the method for getting information from user about the book they wish to add
     * It is if/else thing to either, if it is possible through addNewBook() in Arraylist, add
     * the book, or state that the book already exists
     */
    private static void addNewBook() {
        System.out.println();
        System.out.println("Write name of book:");
        String name = scanner.nextLine();
        System.out.println("Write release year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write author:");
        String author = scanner.nextLine();
        System.out.println("How many stars has it received from critics?");
        float stars = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("How many minutes is the book?");
        String minutes = scanner.nextLine();
        System.out.println();
        //Object if being made:
        AudioBook newBook = AudioBook.createBook(name, year, author, stars, minutes);
        //Adds book if its name is not already in Array, via Array-method
        if (bookshelf.addNewBook(newBook)) {
            System.out.println("This book has been added to shelf: \n" + name + "\nYear: " + year);
            System.out.println();
        } else {
            System.out.println(name + " is already in bookshelf.");
        }
    }

    /**
     * This is the method for "Borrow book", it just removes a book from the Arraylist if
     * it is represented, or it states that it is not in the Arraylist.
     */
    private static void removeBook() {
        System.out.println();
        System.out.println("Name book you would like to borrow:");
        String name = scanner.nextLine();
        Book existingBook = bookshelf.queBook(name);
        if (existingBook == null) {
            System.out.println("Cannot find book in Shelf.");
            return;
        }

        if (bookshelf.removeBook((AudioBook) existingBook)) {
            System.out.println("Book has been removed from Shelf.");
        }
    }

    /*
    Underneath are the methods for use of option 5 "Search for book", here you can scan the library for specific
    title, author and year.
     */

    /**
     * This method get information by user and
     * uses queBook() in BookshelfAudio to scan for objects based on one variable in Arraylist.
     * It prints objects with the variable asked by user, or states that it is not represented in Arraylist if not.
     */
    private static void searchForTitle() {
        System.out.println();
        System.out.println("Name title you would like to search for:");
        String title = scanner.nextLine();
        Book existingBook = bookshelf.queBook(title);
        if (existingBook == null) {
            System.out.println("Cannot find " + title + " in library.");
            return;
        }

        if (existingBook != null) {
            System.out.println("Books named " + title + ": ");
            bookshelf.printTitle(title);
            return;
        }
    }

    /**
     * This method get information by user and
     * uses queAuthor() in BookshelfAudio to scan for objects based on one variable in Arraylist.
     * It prints objects with the variable asked by user, or states that it is not represented in Arraylist if not.
     */
    private static void searchForAuthor() {
        System.out.println();
        System.out.println("Name author you would like to search for:");
        String author = scanner.nextLine();
        Book existingBook = bookshelf.queAuthor(author);
            if (existingBook == null) {
                System.out.println("Cannot find " + author + " in library.");
                return;
            }

            if (existingBook != null) {
                System.out.println("Books by " + author +":");
                bookshelf.printAuthor(author);
                return;
            }
        }

    /**
     * This method get information by user and
     * uses queBookYear() in BookshelfAudio to scan for objects based on one variable in Arraylist.
     * It prints objects with the variable asked by user, or states that it is not represented in Arraylist if not.
     */
    private static void searchForYear() {
        System.out.println();
        System.out.println("Name year you would like to search for:");
        int yearX = scanner.nextInt();
        scanner.nextLine();

            Book existingBook = bookshelf.queBookYear(yearX);
             if (existingBook == null) {
                 System.out.println("Cannot find year " + yearX + " in library.");
                 return;
            }

            if (existingBook != null) {
                System.out.println("Books published in " + yearX + ":");
                 bookshelf.printYear(yearX);
                return;
             }


    }

    //Methods for PaperBooks:

    /**
     * This is the method for getting information from user about the book they wish to add
     * It is if/else thing to either, if it is possible through addNewBook() in Arraylist, add
     * the book, or state that the book already exists
     */
    private static void addNewBook2() {
        System.out.println();
        System.out.println("Write name of book:");
        String name = scanner.nextLine();
        System.out.println("Write release year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write author:");
        String author = scanner.nextLine();
        System.out.println("How many stars has it received from critics?");
        float stars = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("How many pages is the book?");
        String pages = scanner.nextLine();
        System.out.println();
        //Object if being made:
        PaperBook newBook = PaperBook.createBook(name, year, author, stars, pages);
        //Adds Object to Array if name is not already represented in ArrayList
        if (bookshelf2.addNewBook(newBook)) {
            System.out.println("This book has been added to shelf: \n" + name + "\nYear: " + year);
            System.out.println();
        } else {
            System.out.println(name + " is already in bookshelf.");
        }
    }

    /**
     * This is the method for "Borrow book", it just removes a book from the Arraylist if
     * it is represented, or it states that it is not in the Arraylist.
     */
    private static void removeBook2() {
        System.out.println();
        System.out.println("Name book you would like to borrow:");
        String name = scanner.nextLine();
        Book existingBook = bookshelf2.queBook(name);
        if (existingBook == null) {
            System.out.println("Cannot find book in Shelf.");
            return;
        }

        if (bookshelf2.removeBook((PaperBook) existingBook)) {
            System.out.println("Book has been removed from Shelf.");
        }
    }

    /*
    Underneath are the methods for use of option 5 "Search for book", here you can scan the library for specific
    title, author and year.
     */

    /**
     * This method get information by user and
     * uses queBook() in BookshelfPaper to scan for objects based on one variable in Arraylist.
     * It prints objects with the variable asked by user, or states that it is not represented in Arraylist if not.
     */
    private static void searchForTitle2() {
        System.out.println();
        System.out.println("Name title you would like to search for:");
        String title = scanner.nextLine();
        Book existingBook = bookshelf2.queBook(title);
        if (existingBook == null) {
            System.out.println("Cannot find " + title + " in library.");
            return;
        }

        if (existingBook != null) {
            System.out.println("Books named " + title + ": ");
            bookshelf2.printTitle(title);
            return;
        }
    }

    /**
     * This method get information by user and
     * uses queAuthor() in BookshelfPaper to scan for objects based on one variable in Arraylist.
     * It prints objects with the variable asked by user, or states that it is not represented in Arraylist if not.
     */
    private static void searchForAuthor2() {
        System.out.println();
        System.out.println("Name author you would like to search for:");
        String author = scanner.nextLine();
        Book existingBook = bookshelf2.queAuthor(author);
        if (existingBook == null) {
            System.out.println("Cannot find " + author + " in library.");
            return;
        }

        if (existingBook != null) {
            System.out.println("Books by " + author +":");
            bookshelf2.printAuthor(author);
            return;
        }
    }

    /**
     * This method get information by user and
     * uses queBookYear() in BookshelfPaper to scan for objects based on one variable in Arraylist.
     * It prints objects with the variable asked by user, or states that it is not represented in Arraylist if not.
     */
    private static void searchForYear2() {
        System.out.println();
        System.out.println("Name year you would like to search for:");
        int yearX = scanner.nextInt();
        scanner.nextLine();

        Book existingBook = bookshelf2.queBookYear(yearX);
        if (existingBook == null) {
            System.out.println("Cannot find year " + yearX + " in library.");
            return;
        }

        if (existingBook != null) {
            System.out.println("Books published in " + yearX + ":");
            bookshelf2.printYear(yearX);
            return;
        }


    }


}