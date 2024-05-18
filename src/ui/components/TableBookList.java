package ui.components;

import java.util.List;

import entities.books.BookForLoan;
import interfaces.IMenuAction;

public class TableBookList implements IMenuAction<List<BookForLoan>> {
    public String displayFormat = "| %-3s | %-10s | %-50s | %-20s | %-5s | %-10s |%n";
    public String displayBorder = "---------------------------------------------------------------------------------------------------------------------%n";
    public String displayBorderHeader = "=====================================================================================================================%n";

    public TableBookList() {

    }

    public void printHeader(String menuName) {
        System.out.format(displayBorderHeader);
        System.out.format("| %-113s |%n", menuName.toUpperCase());
        System.out.format(displayBorderHeader);
        System.out.printf(displayFormat, "No", "Book ID", "Title", "Author", "Stock", "Loan Price");
        System.out.format(displayBorderHeader);
    }

    public void printBody(List<BookForLoan> bookList) {
        if (bookList.size() > 0) {
            for (int i = 0; i < bookList.size(); i++) {
                BookForLoan book = bookList.get(i);
                System.out.format(displayFormat, i + 1, book.getId(), book.getTitle(), book.getAuthor(),
                        book.getStock(), book.getLoanPrice());
                System.out.format(displayBorder);
            }
        } else {
            System.out.format("| %-113s |%n", "Tidak ada data");
            System.out.format(displayBorder);
        }

    }
}
