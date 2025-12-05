package Service;

import entity.Card;
import entity.TransactionLog;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

import static Service.CardOperationsMenu.printCards;

public class TransactionMenu {
    Scanner intInput = new Scanner(System.in);
    TransactionLog tLog = new TransactionLog();


    public void loadTransactionMenu(Integer userId) {
        while (true) {
            System.out.println("""
                    1. Card Transaction
                    2. Paya (Personal)
                    3. Paya (group)
                    4. Satna
                    5. back""");
            int choose = intInput.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("choose a card number: ");
                    ArrayList<Card> myCards = ApplicationContext.cardService.showAllCards(userId);
                    String srcCardNum = printCards(ApplicationContext.cardService.showAllCards(userId));
                    System.out.println("choose destination card number: ");
                    Card srcCard = ApplicationContext.cardService.selectCard(srcCardNum);
                    String destCardNum = printCards(ApplicationContext.cardService.allCards());
                    Card destCard = ApplicationContext.cardService.selectCard(destCardNum);
                    int amount;
                    do {
                        System.out.println("enter a valid amount: ");
                        amount = intInput.nextInt();

                    } while (amount > 15000000 && amount < 0);

                    tLog = new TransactionLog(srcCard, destCard, amount);
                    tLog.cToCTransaction();
                    ApplicationContext.transactionLogService.cardTransaction(tLog,1);

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    return;
            }
        }
    }
}
