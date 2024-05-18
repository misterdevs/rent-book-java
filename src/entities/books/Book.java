package entities.books;

public abstract class Book {
    private String id;
    private String title;
    private String author;
    private int price;

    public Book() {

    }

    public Book(String id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        String string = "[" + this.id + "," + this.title + "," + this.author + "," + this.price
                + "]";
        return string;
    }

}
