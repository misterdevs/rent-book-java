package ui;

import java.util.List;
import java.util.Scanner;

import entities.books.BookForLoan;
import entities.loan.ServiceOrder;
import ui.components.TableBookList;
import ui.components.TableOrderList;
import utilities.Utility;
import utilities.UtilityMenu;

public class MainMenu {
    private Scanner scanner;
    private UtilityMenu menu;
    private List<BookForLoan> booksForLoan;
    int chosenMenu;

    public MainMenu(List<BookForLoan> booksForLoan) {
        this.scanner = new Scanner(System.in);
        this.menu = new UtilityMenu();
        this.booksForLoan = booksForLoan;

    }

    public MainMenu Main() {
        ServiceOrder serviceOrder = new ServiceOrder(booksForLoan);
        TableBookList tableBookList = new TableBookList();
        TableOrderList tableOrderList = new TableOrderList();
        Utility utility = new Utility();
        do {
            menu.resetDisplay();
            String[] mainMenuArray = { "Data All Book for Loan", "Loan", "Return", "Data All Loan Order" };
            String input = menu.createMenu("Aplikasi Rental Buku by MRDevs", mainMenuArray, "0. Exit").print();

            if (utility.isNumber(input)) {
                this.chosenMenu = Integer.valueOf(input);
            } else {
                this.chosenMenu = 99;
            }
            menu.resetDisplay();
            switch (this.chosenMenu) {
                case 1:
                    tableBookList.printHeader("data book for loan");
                    tableBookList.printBody(booksForLoan);
                    menu.enterToContinue();
                    break;
                case 2:
                    tableBookList.printHeader("loan book");
                    tableBookList.printBody(booksForLoan);
                    if (menu.confirmation("Ingin meminjam buku?")) {
                        serviceOrder.loanOrder();
                    }
                    break;
                case 3:
                    tableOrderList.printHeader("return book");
                    tableOrderList.printBody(serviceOrder.getOrderList());
                    if (menu.confirmation("Ingin mengembalikan buku?")) {
                        serviceOrder.loanReturn();
                    }
                    break;
                case 4:
                    tableOrderList.printHeader("data loan order");
                    tableOrderList.printBody(serviceOrder.getOrderList());
                    menu.enterToContinue();
                    break;
                default:
                    break;
            }

        } while (this.chosenMenu != 0);

        System.out.println("==========================================");
        System.out.println("APPLICATION HAS BEEN CLOSED");
        System.out.println("==========================================");

        scanner.close();
        System.exit(0);

        return this;
    }

    public int print() {
        return chosenMenu;
    }

}
