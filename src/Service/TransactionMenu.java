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
                    ApplicationContext.transactionLogService.cardTransaction(tLog);
                    break;
                case 2:
                    System.out.println("choose a card number: ");
                    myCards = ApplicationContext.cardService.showAllCards(userId);
                    srcCardNum = printCards(ApplicationContext.cardService.showAllCards(userId));
                    System.out.println("choose destination card number: ");
                    srcCard = ApplicationContext.cardService.selectCard(srcCardNum);
                    destCardNum = printCards(ApplicationContext.cardService.allCards());
                    destCard = ApplicationContext.cardService.selectCard(destCardNum);
                    do {
                        System.out.println("enter a valid amount: ");
                        amount = intInput.nextInt();

                    } while (amount > 50000000 && amount < 0);

                    tLog = new TransactionLog(srcCard, destCard, amount);
                    tLog.payaPersonalTransaction();
                    ApplicationContext.transactionLogService.cardTransaction(tLog);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("choose a card number: ");
                    myCards = ApplicationContext.cardService.showAllCards(userId);
                    srcCardNum = printCards(ApplicationContext.cardService.showAllCards(userId));
                    System.out.println("choose destination card number: ");
                    srcCard = ApplicationContext.cardService.selectCard(srcCardNum);
                    destCardNum = printCards(ApplicationContext.cardService.allCards());
                    destCard = ApplicationContext.cardService.selectCard(destCardNum);
                    do {
                        System.out.println("enter a valid amount: ");
                        amount = intInput.nextInt();

                    } while (amount > 200000000 && amount < 50000000);

                    tLog = new TransactionLog(srcCard, destCard, amount);
                    tLog.satnaTransaction();
                    ApplicationContext.transactionLogService.cardTransaction(tLog);
                    break;
                case 5:
                    return;
            }
        }
    }
}
