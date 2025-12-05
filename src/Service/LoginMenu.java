package Service;

import util.ApplicationContext;

import java.util.Scanner;

public class LoginMenu {
    CardOperationsMenu cardMenu = new CardOperationsMenu();
    TransactionMenu transactionMenu = new TransactionMenu();

    static Scanner intInput = new Scanner(System.in);

    public void menu(int userId) {
        while (true) {

            System.out.println("""
                    1. Card Operations
                    2. Transaction operations
                    3. back""");

            int chosenMenu = intInput.nextInt();

            switch (chosenMenu) {
                case 1:
                    cardMenu.CardMenu(userId);
                    break;
                case 2:
                    transactionMenu.loadTransactionMenu(userId);
                    break;
                case 3:
                    return;
            }
        }
    }
}
