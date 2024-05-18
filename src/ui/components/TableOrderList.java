package ui.components;

import java.util.List;

import entities.loan.Order;
import interfaces.IMenuAction;

public class TableOrderList implements IMenuAction<List<Order>> {
    public String displayFormat = "| %-3s | %-10s | %-15s | %-10s  | %-50s | %-10s | %-15s | %-10s |%n";
    public String displayBorder = "-----------------------------------------------------------------------------------------------------------------------------------------------------%n";
    public String displayBorderHeader = "=====================================================================================================================================================%n";

    public TableOrderList() {

    }

    public void printHeader(String menuName) {
        System.out.format(displayBorderHeader);
        System.out.format("| %-145s |%n", menuName.toUpperCase());
        System.out.format(displayBorderHeader);
        System.out.printf(displayFormat, "No", "Loan ID", "Member Name", "Book ID", "Title", "Loan Price",
                "Loan Duration",
                "Loan Fee");
        System.out.format(displayBorderHeader);
    }

    public void printBody(List<Order> orderList) {
        if (orderList.size() > 0) {
            for (int i = 0; i < orderList.size(); i++) {
                Order order = orderList.get(i);
                System.out.format(displayFormat, i + 1, order.getId(), order.getMember().getName(),
                        order.getBook().getId(),
                        order.getBook().getTitle(), order.getLoanPrice(), order.getDuration(), order.getFee());
                System.out.format(displayBorder);
            }
        } else {
            System.out.format("| %-145s |%n", "Tidak ada data");
            System.out.format(displayBorder);
        }

    }
}
