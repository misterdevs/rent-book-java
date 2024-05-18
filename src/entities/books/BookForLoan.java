package entities.books;

public abstract class BookForLoan extends Book {
    private int loanPrice;
    private int stock;

    public BookForLoan() {
    };

    public BookForLoan(String id, String title, String author, int price, int stock) {
        super(id, title, author, price);
        this.stock = stock;
    }

    public int getLoanPrice() {
        return loanPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setLoanPrice(int loanPrice) {
        this.loanPrice = loanPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        String string = "[" + getId() + "," + getTitle() + "," + getAuthor()
                + "," + getStock() + "," + getPrice() + "," + getLoanPrice() + "]";
        return string;
    }

    abstract void calculateLoanPrice();

}
