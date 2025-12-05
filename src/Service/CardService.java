package Service;

import entity.Card;
import repository.CardRepository;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class CardService {
    static Scanner intInput = new Scanner(System.in);
    static Scanner stringInput = new Scanner(System.in);
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public ArrayList<Card> allCards() {
        return ApplicationContext.cardRepository.allCards();
    }

    public Card selectCard(String cardNumber){
        return (Card) cardRepository.findBy("card_number",cardNumber);
    }
    public ArrayList<Card> showCards(String column, String value, Integer id) {
        return ApplicationContext.cardRepository.findBy(column, value, id);
    }

    public ArrayList<Card> showAllCards(Integer id) {
        return ApplicationContext.cardRepository.showAll(id);
    }

    public void addCard(Integer userId) {
        boolean add = false;
        String cardNumber, bankName;
        while (!add) {
            System.out.println("please enter your card number:");
            cardNumber = Long.toString(intInput.nextLong());
            Card found = (Card) cardRepository.findBy("card_number", cardNumber);
            if (found == null) {
                System.out.println("please enter your bankName:");
                bankName = stringInput.nextLine();
                cardRepository.save(new Card(cardNumber, bankName, userId));
                System.out.println("Card added successfully!");
                return;
            } else {
                System.out.println("Card number already exist!");
            }
        }
    }

    public void removeCard(String cardNumber) {
        cardRepository.remove(cardNumber);
    }
}
