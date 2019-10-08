package com.Bookshelf;

import java.util.Scanner;

public class Main {

    //Connection to Arraylists and introduction to scanner
    private static Scanner scanner = new Scanner(System.in);
    public static BookshelfAudio bookshelf = new BookshelfAudio();
    public static BookshelfPaper bookshelf2 = new BookshelfPaper();

    //This is where we run the program:
    public static void main(String[] args) {

        //Main boolean where user choose between Audio and Paper
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
                                searchForBook();
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

                    //While and Switchcase 1.2
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
                                searchForBook2();
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

    //1st list of options
    private static void printWelcome() {
        System.out.println("Welcome to BookShelf! What type of shelf would you like to access?");
        System.out.println("\t 0 - Quit Bookshelf");
        System.out.println("\t 1 - Audiobook-Shelf");
        System.out.println("\t 2 - Paperbook-Shelf");
    }

    //2nd list of options user has to consider
    private static void printOptions() {
        System.out.println("Options in Bookshelf:");
        System.out.println("\t 0 - Show options");
        System.out.println("\t 1 - Add book");
        System.out.println("\t 2 - Show current Bookshelf");
        System.out.println("\t 3 - Remove book");
        System.out.println("\t 4 - Sort book by critics");
        System.out.println("\t 5 - Search for book");
        System.out.println("\t 6 - Back to main menu");
    }

    //Methods for AudioBooks:
    //Method for getting values to variables and adding object to Arraylist if not already there
    private static void addNewBook() {
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

    //Method for removing book from Arraylist if its name is represented there
    private static void removeBook() {
        System.out.println("Name book you would like to remove:");
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

    private static void searchForBook() {
        System.out.println("Name year you would like to search for:");
        int yearX = scanner.nextInt();
        scanner.nextLine();
        Book existingBook = bookshelf.queBookYear(yearX);
        if (existingBook == null) {
            System.out.println("Cannot find year represented");
            return;
        }

        if (existingBook != null) {
            System.out.println("Something here");
            bookshelf.printYear(yearX);
            return;
        }


    }

    //Methods for PaperBooks:
    //Method for getting information about book and adding it to Arraylist
    private static void addNewBook2() {
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

    //Method for removing book from Arraylist if its name is represented there
    private static void removeBook2() {
        System.out.println("Name book you would like to remove:");
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

    private static void searchForBook2() {
        System.out.println("Name year you would like to search for:");
        int yearX = scanner.nextInt();
        scanner.nextLine();

        Book existingBook = bookshelf2.queBookYear(yearX);
        if (existingBook == null) {
            System.out.println("Cannot find year represented");
            return;
        }
        if (existingBook != null) {
            System.out.println("Something here");
            bookshelf2.printYear(yearX);
            return;
        }


    }


}