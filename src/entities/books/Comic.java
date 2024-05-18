package entities.books;

public class Comic extends BookForLoan {
    private String genre;

    public Comic() {

    }

    public Comic(String id, String title, String genre, String author, int price, int stock) {
        super(id, title, author, price, stock);
        this.genre = genre;
        calculateLoanPrice();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void calculateLoanPrice() {
        double ratePercentageByStock;
        double ratePercentageByBookType;
        if (getStock() < 10) {
            ratePercentageByStock = 5;
        } else {
            ratePercentageByStock = 3;
        }
        ratePercentageByBookType = 10;
        int calculate = (int) (ratePercentageByStock + ratePercentageByBookType) * getPrice() / 100;
        setLoanPrice(calculate);

    }

    @Override
    public String toString() {
        String string = "[" + getId() + "," + getTitle() + "," + this.genre + "," + getAuthor()
                + "," + getStock() + "," + getPrice() + "," + getLoanPrice() + "]";
        return string;
    }

}
