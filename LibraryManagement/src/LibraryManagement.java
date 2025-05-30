import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;
public class LibraryManagement {
    private static LibraryManagement instance;
    private final Catalog catalog;
    private final Map<String,Member>members;
    private final Map<String,Loan>loans;

    public LibraryManagement(){
        catalog = new Catalog();
        members = new ConcurrentHashMap<>();
        loans = new ConcurrentHashMap<>();

    }
    public static synchronized LibraryManagement getInstance(){
        if(instance==null){
            instance = new LibraryManagement();
        }
        return instance;
    }

    public void addBook(Book book){
        BookCopy copy = new BookCopy(book);
        catalog.AddBook(copy);

    }
    public Member registerMember(String name,String contactInfo){
        Member member = new Member(name,contactInfo);
        members.put(member.getId(),member);
        return member;
    }
    public synchronized Loan borrowBook(String memberId,String title){
        Member member = members.get(memberId);
        if(member==null||!member.canBorrow()){
            throw new IllegalStateException("Not allowed to borrow");
        }
        List<BookCopy>copies = catalog.getBookCopiesTitle(title);
        for(BookCopy copy:copies){
            if(copy.isAvailable()){
                copy.markIssued();
                Loan loan = new Loan(copy,member);
                member.addLoan(loan);
                loans.put(loan.getId(),loan);
                System.out.println("Book borrowed: " + copy.getBook().getTitle() + " by " + member.getName());
                return  loan;
            }
        }
        throw new RuntimeException("No Available copy");
    }
    public synchronized void returnBook(String loadId){
        Loan loan = loans.get(loadId);
        loan.closeLoan();
    }
    public List<Book>searchByTitle(String title){
        return catalog.searchBookByTitle(title);
    }
    public List<Book>searchByAuthor(String author){
        return catalog.searchBookByAuthor(author);
    }
    public List<Book>searchByIsbn(String isbn){
        return catalog.searchBookByIsbn(isbn);
    }
}
