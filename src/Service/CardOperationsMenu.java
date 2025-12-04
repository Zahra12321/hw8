package Service;

import entity.Card;
import util.ApplicationContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CardOperationsMenu {
    private static Scanner intInput = new Scanner(System.in);
    private static Scanner stringInput = new Scanner(System.in);
    private ArrayList<Card> cards = new ArrayList<>();

    public void CardMenu(Integer userId) {
        while (true) {

            int choose = intInput.nextInt();

            switch (choose) {
                case 1:
                    ApplicationContext.cardService.addCard(userId);

                    break;
                case 2:
                    cards = ApplicationContext.cardService.showCards("*",userId);
                    String deleteCard = cardToDelete();
                    ApplicationContext.cardService.removeCard(deleteCard);
                    break;
                case 3:
                    String cardNumber = Integer.toString(intInput.nextInt());
                    System.out.println(ApplicationContext.cardService.showCards(cardNumber,userId));
                    break;
                case 4:
                    String bankName = stringInput.nextLine();
                    System.out.println(ApplicationContext.cardService.showCards(bankName,userId));
                    break;
                case 5:
                    System.out.println(ApplicationContext.cardService.showCards("*",userId));
                    break;
                case 6:
                    return;
            }
        }
    }

    public String cardToDelete() {
        int counter = 0;
        while (counter < cards.size()) {
            System.out.println((1 + counter) + cards.get(counter).toString());
        }
        int delete = intInput.nextInt();
        return cards.get(delete - 1).getCardNumber();
    }

}
