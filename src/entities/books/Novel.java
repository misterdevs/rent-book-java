package entities.books;

public class Novel extends BookForLoan {
    Boolean series;

    public Novel() {

    }

    public Novel(String id, String title, Boolean series, String author, int price, int stock) {
        super(id, title, author, price, stock);
        this.series = series;
        calculateLoanPrice();
    }

    public Boolean getSeries() {
        return series;
    }

    public void setSeries(Boolean series) {
        this.series = series;
    }

    public void calculateLoanPrice() {
        double ratePercentageByStock;
        double ratePercentageByBookType;
        if (getStock() < 10) {
            ratePercentageByStock = 5;
        } else {
            ratePercentageByStock = 3;
        }
        ratePercentageByBookType = 5;
        int calculate = (int) (ratePercentageByStock + ratePercentageByBookType) * getPrice() / 100;
        setLoanPrice(calculate);
    }

    @Override
    public String toString() {
        String string = "[" + getId() + "," + getTitle() + "," + this.series + "," + getAuthor()
                + "," + getStock() + "," + getPrice() + "," + getLoanPrice() + "]";
        return string;
    }

}
