package bookstore;

import java.util.Scanner;

public class BookstoreTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of books: ");

        int number = scanner.nextInt();

        Book[] books = new Book[number];


        for(int i = 0; i < number; i ++){
            scanner.nextLine();
            System.out.println("Title: ");
            String title = scanner.nextLine();

            System.out.println("Author: ");
            String author = scanner.nextLine();

            System.out.println("Publisher: ");
            String publisher = scanner.nextLine();

            System.out.println("Number of pages: ");
            int pageCount = scanner.nextInt();


            if(pageCount <= 0){
                System.out.println("You have entered a negative number or 0. Please enter a positive one: ");
                pageCount = scanner.nextInt();
            }

            Book book = new Book(title, author, publisher, pageCount);
            System.out.println(book);

            books[i] = book;
        }


        Book[] testBooks = {new Book("La Medeleni", "Ion Teodoreanu", "Lyceum", 207), new Book("Maitreyi", "Mircea Eliade", "Cultura Nationala", 250), new Book("La Medeleni", "Ion Teodoreanu", "Lyceum", 207), new Book("Nunta in cer", "Mircea Eliade", "Cartex", 300)};

        Book book = new Book("La Medeleni", "Ion Teodoreanu", "Lyceum", 207);

        System.out.println(BookstoreCheck.checkNoOfPages(testBooks[1], book));
        System.out.println(BookstoreCheck.checkDuplicates(testBooks, book));

    }
}
