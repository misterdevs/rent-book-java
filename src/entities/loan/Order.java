package entities.loan;

import java.util.ArrayList;
import java.util.List;

import entities.books.BookForLoan;
import entities.members.Member;

public class Order {
    private String id;
    private Member member;
    private BookForLoan book;
    private int duration;
    private int fee;
    private int loanPrice;
    private List<Order> orderList = new ArrayList<Order>();

    public Order() {

    }

    public Order(String id, Member member, BookForLoan book, int duration) {
        super();
        this.id = id;
        this.member = member;
        this.book = book;
        this.duration = duration;
        this.loanPrice = book.getLoanPrice();
        calculateFee();
    }

    public String getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public BookForLoan getBook() {
        return book;
    }

    public int getDuration() {
        return duration;
    }

    public int getFee() {
        return fee;
    }

    public int getLoanPrice() {
        return loanPrice;
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setBook(BookForLoan book) {
        this.book = book;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setLoanPrice(int loanPrice) {
        this.loanPrice = loanPrice;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String toString() {
        String string = "[" + this.id + "," + this.member + "," + this.book + "," + this.duration + "," + this.loanPrice
                + "," + this.fee
                + "]";
        return string;
    }

    public void calculateFee() {
        int calculate = book.getLoanPrice() * this.duration;
        setFee(calculate);
    }

}
