package entities.loan;

import java.util.List;
import java.util.stream.Collectors;

import entities.books.BookForLoan;
import entities.books.Comic;
import entities.books.Novel;
import entities.members.Member;
import repositories.RepositoryMember;
import utilities.Utility;
import utilities.UtilityInput;

public class ServiceOrder extends Order {
    private List<BookForLoan> bookForLoan;
    private final Utility utility = new Utility();
    private final UtilityInput input = new UtilityInput();
    private String idPattern = "Order-000";
    private int orderNumber = 1;

    public ServiceOrder(List<BookForLoan> bookForLoan) {
        this.bookForLoan = bookForLoan;

    }

    public void loanOrder() {
        Member member = getMemberById(input.validate("Masukkan Member ID", "Member ID tidak ditemukan!",
                this::isValidMemberId));
        BookForLoan book = getBookById(input.validate("Masukkan Book ID", "Book ID tidak ditemukan!",
                this::isValidBookId));
        int duration = Integer.valueOf(input.validate("Lama Peminjaman (hari)", "Hanya dapat memasukkan angka",
                s -> utility.isNumber(s) && Integer.valueOf(s) > 0));
        createLoanOrder(member, book, duration);
    }

    public void loanReturn() {
        Order order = getOrderById(input.validate("Masukkan Loan ID", "Loan ID tidak ditemukan!",
                this::isValidOrderId));
        deleteLoanOrder(order);
    }

    public void createLoanOrder(Member member, BookForLoan book, int duration) {
        String bookType = getBookTypeById(book);
        getOrderList().add(new Order(createId(), member, book, duration));
        book.setStock(book.getStock() - 1);
        calculateLoanPrice(book, bookType);
    }

    public void deleteLoanOrder(Order order) {
        String bookType = getBookTypeById(order.getBook());
        BookForLoan book = order.getBook();
        getOrderList().remove(getOrderList().indexOf(order));
        book.setStock(order.getBook().getStock() + 1);
        calculateLoanPrice(book, bookType);
    }

    public Member getMemberById(String memberId) {
        RepositoryMember repoMember = new RepositoryMember();
        List<Member> members = repoMember.getMember().stream()
                .filter(member -> member.getId().equalsIgnoreCase(memberId) == true).collect(Collectors.toList());

        if (members.size() > 0) {
            return members.getFirst();
        } else {
            return null;
        }
    }

    public String getBookTypeById(BookForLoan book) {
        return book.getId().toLowerCase().split("-")[0];
    }

    public BookForLoan getBookById(String bookId) {
        List<BookForLoan> books = bookForLoan.stream()
                .filter(book -> book.getId().equalsIgnoreCase(bookId) == true).collect(Collectors.toList());
        if (books.size() > 0) {
            return books.getFirst();
        } else {
            return null;
        }
    }

    public Order getOrderById(String orderId) {
        List<Order> orders = getOrderList().stream()
                .filter(book -> book.getId().equalsIgnoreCase(orderId) == true).collect(Collectors.toList());
        if (orders.size() > 0) {
            return orders.getFirst();
        } else {
            return null;
        }
    }

    public boolean isValidMemberId(String memberId) {
        return getMemberById(memberId) != null;
    }

    public boolean isValidBookId(String bookId) {
        return getBookById(bookId) != null;
    }

    public boolean isValidOrderId(String orderId) {
        return getOrderById(orderId) != null;
    }

    public String createId() {
        return utility.createIdPattern(idPattern, orderNumber++);
    }

    private void calculateLoanPrice(BookForLoan book, String bookType) {
        switch (bookType) {
            case "comic":
                Comic comicBook = (Comic) book;
                comicBook.calculateLoanPrice();
                break;
            case "novel":
                Novel novelBook = (Novel) book;
                novelBook.calculateLoanPrice();
                break;
            default:
                break;
        }

    }

}
