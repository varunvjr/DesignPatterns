import java.util.HashMap;
import java.util.*;
public class Catalog {
    private HashMap<String,List<BookCopy>>byTitle = new HashMap<>();
    private HashMap<String,List<BookCopy>>byAuthor = new HashMap<>();
    private HashMap<String,List<BookCopy>>byIsbn = new HashMap<>();
    public synchronized void AddBook(BookCopy copy){
        Book book = copy.getBook();
        if(!byTitle.containsKey(book.getTitle())){
            byTitle.put(book.getTitle(),new ArrayList<>());
        }
        byTitle.get(book.getTitle()).add(copy);
        if (!byAuthor.containsKey(book.getAuthor())) {
            byAuthor.put(book.getAuthor(), new ArrayList<>());
        }
        byAuthor.get(book.getAuthor()).add(copy);
        if (!byIsbn.containsKey(book.getIsbn())) {
            byIsbn.put(book.getIsbn(), new ArrayList<>());
        }
        byIsbn.get(book.getIsbn()).add(copy);
    }
    public synchronized List<BookCopy> getBookCopiesTitle(String title){
        return byTitle.getOrDefault(title,List.of());
    }
    public synchronized List<Book> searchBookByTitle(String title){
        return byTitle.getOrDefault(title,List.of()).stream()
                .map(BookCopy::getBook)
                .distinct()
                .toList();
    }

    public synchronized List<Book> searchBookByAuthor(String author){
        return byTitle.getOrDefault(author,List.of()).stream()
                .map(BookCopy::getBook)
                .distinct()
                .toList();
    }
    public synchronized List<Book> searchBookByIsbn(String isbn){
        return byTitle.getOrDefault(isbn,List.of()).stream()
                .map(BookCopy::getBook)
                .distinct()
                .toList();
    }

}

