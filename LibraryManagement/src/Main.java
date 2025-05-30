import java.util.List;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Library Management");
        LibraryManagement libraryManagement = LibraryManagement.getInstance();
        libraryManagement.addBook(new Book("1234","Fire and Ice","GG Martin"));
        libraryManagement.addBook(new Book("1233","Fire and Glass","GG Martin"));
        libraryManagement.addBook(new Book("1232","Fire and Storm","GG Martin"));

        // Register members
        Member member1 = libraryManagement.registerMember("John Doe", "john@example.com");
        Member member2 = libraryManagement.registerMember("Jane Smith", "jane@example.com");
        Loan loan1 = libraryManagement.borrowBook(member1.getId(),"Fire and Ice");
        Loan loan2 = libraryManagement.borrowBook(member2.getId(),"Fire and Glass");

        libraryManagement.returnBook(loan1.getId());
        // Search by Authors
        List<Book>searchResults = libraryManagement.searchByAuthor("GG Martin");
        for(Book book:searchResults){
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

    }
}