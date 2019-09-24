package com.Bookshelf;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static Bookshelf bookshelf = new Bookshelf();

    public static void main(String[] args) {

        boolean quit = false;
        printOptions();

        while(!quit){
            System.out.println("Choose option:");
            int choise = scanner.nextInt();
            scanner.nextLine();

            switch(choise){
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
                    quit = true;
                    break;


            }
        }


    }


    private static void printOptions(){
        System.out.println("Options in Bookshelf:");
        System.out.println("\t 0 - Show options");
        System.out.println("\t 1 - Add book");
        System.out.println("\t 2 - Show Bookshelf");
        System.out.println("\t 3 - Remove book");
        System.out.println("\t 4 - Quit");
    }

    private static void addNewBook(){
        System.out.println("Write name of book:");
        String name = scanner.nextLine();
        System.out.println("Write release year:");
        String year = scanner.nextLine();
        System.out.println("Write author:");
        String author = scanner.nextLine();
        //Objekt skapes:
        Book newBook = Book.createBook(name, year, author);
        //Legger til objektet i arrayen om den ikke allerede er der.
        if (bookshelf.addNewBook(newBook)){
            System.out.println("This book has been added to shelf: \n" + name + "\nYear: " + year + "\nAuthor: " + author);
        }
        else {
            System.out.println(name + " is already in bookshelf.");
        }
    }

        private static void removeBook(){
            System.out.println("Name book you would like to remove:");
            String name = scanner.nextLine();
            Book existingBook = bookshelf.queBook(name);
            if (existingBook == null){
                System.out.println("Cannot find book in Shelf.");
                return;
            }

            if (bookshelf.removeBook(existingBook)){
                System.out.println("Book has been removed from Shelf.");
            }
        }

}

