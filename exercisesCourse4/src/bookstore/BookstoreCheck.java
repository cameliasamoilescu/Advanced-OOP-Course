package bookstore;

public class BookstoreCheck {

    public static boolean checkDuplicates(Book[] books, Book book) {

        // the book appears n times
        int n = 0;

        for (int i = 0; i < books.length; i++) {
            if (book.equals(books[i])) {
                n += 1;
                if (n == 2) {
                    return true;
                }
            }
        }

        return false;
    }


    public static Book checkNoOfPages(Book a, Book b){
        if (a.getPageCount() > b.getPageCount())
            return a;
        else
            return b;
    }

}
