package utilities;

import java.util.Scanner;

public class UtilityMenu extends Utility {
    private Scanner scanner;
    String chosenMenu;

    public UtilityMenu() {
        this.scanner = new Scanner(System.in);
    }

    public Boolean confirmation(String dialog) {
        return confirmationCustom(dialog + " (y/n)", "y", "n");
    }

    public Boolean confirmationCustom(String dialog, String yes, String no) {
        String input;
        do {
            System.out.print(dialog + " : ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase(yes)) {
                return true;
            } else if (input.equalsIgnoreCase(no)) {
                return false;
            }
        } while (true);
    }

    public void enterToContinue() {
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
    }

    public void resetDisplay() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public UtilityMenu createMenu(String menuName, String[] menuArray, String navigationMenu) {
        String displayBorder = ("==========================================");
        System.out.println(displayBorder);
        System.out.println(menuName);
        System.out.println(displayBorder);
        for (int i = 0; i < menuArray.length; i++) {
            System.out.println((i + 1) + ". " + menuArray[i]);
        }
        if (!navigationMenu.equals("")) {
            System.out.println(navigationMenu);
        }
        System.out.println(displayBorder);
        System.out.print("Pilih menu : ");
        this.chosenMenu = scanner.nextLine();
        return this;
    }

    public String print() {
        return chosenMenu;
    }

}
