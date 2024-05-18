import java.util.List;

import entities.books.BookForLoan;
import repositories.RepositoryBookForLoan;
import ui.MainMenu;

public class App {
    public static void main(String[] args) throws Exception {
        RepositoryBookForLoan repoBookForLoan = new RepositoryBookForLoan();
        List<BookForLoan> booksForLoan = repoBookForLoan.getAllBook();
        MainMenu mainMenu = new MainMenu(booksForLoan);

        mainMenu.Main();

    }
}
