package Service;

import entity.Card;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class CardOperationsMenu {
    private static Scanner intInput = new Scanner(System.in);
    private static Scanner stringInput = new Scanner(System.in);
    private ArrayList<Card> allCards = new ArrayList<>();

    public void CardMenu(Integer userId) {
        while (true) {
            System.out.println("""
                    1. Add card
                    2. Delete card
                    3. Show card info
                    4. Show specified bank's cards
                    5. Show all cards
                    6. back""");
            int choose = intInput.nextInt();

            switch (choose) {
                case 1:
                    ApplicationContext.cardService.addCard(userId);

                    break;
                case 2:
                    allCards = ApplicationContext.cardService.showAllCards(userId);
                    String deleteCard = printCards(allCards);
                    ApplicationContext.cardService.removeCard(deleteCard);
                    break;
                case 3:
                    String cardNumber = Long.toString(intInput.nextLong());
                    System.out.println(ApplicationContext.cardService.showCards("card_number", cardNumber, userId));
                    break;
                case 4:
                    String bankName = stringInput.nextLine();
                    System.out.println(ApplicationContext.cardService.showCards("bank_name", bankName, userId));
                    break;
                case 5:
                    printCards(ApplicationContext.cardService.showAllCards(userId));
                    break;
                case 6:
                    return;
            }
        }
    }

    public static String printCards(ArrayList<Card> cards) {
        int counter = 0;
        while (counter < cards.size()) {
            System.out.println((1 + counter) + ". " + cards.get(counter).toString());
            counter++;
        }
        int select = intInput.nextInt();
        return cards.get(select - 1).getCardNumber();
    }

}
