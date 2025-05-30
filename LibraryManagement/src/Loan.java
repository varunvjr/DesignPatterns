import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private final String id;
    private final BookCopy copy;
    private boolean active = true;
    private final Member member;
    public static int MAX_BORROW_DAYS = 14;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    public Loan(BookCopy copy, Member member){
        this.copy = copy;
        this.id = UUID.randomUUID().toString();
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(MAX_BORROW_DAYS);
    }
    public void closeLoan(){
        copy.markReturned();
        member.removeLoan(this);
        active = false;
    }
    public String getId(){
        return id;
    }
}
