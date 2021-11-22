/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dbhelper.CardDBHelper;
import java.util.UUID;

/**
 *
 * @author User
 */
public class Bank {

    private CardDBHelper cardDBHelper;

    //CreditCard creditCards = new CreditCard();
    // DebitCard1 debitCards = new DebitCard1();
    public Bank() {
        this.cardDBHelper = new CardDBHelper();
    }

    public CardDBHelper getCardDBHelper() {
        return this.cardDBHelper;
    }

    /*
    checks if the card is in the file 
    if it is, it returns an authorization code
    if it is not, it returns a uuid containing all zeros
     */
    public UUID isValid(long cardNumber, int pin) {
        UUID uuid;
        for (int i = 0; i < 3; i++) {
            Card card = cardDBHelper.getCard("debit", cardNumber);
            if (card != null && cardNumber == card.getCardNumber()) {
                DebitCard debitCard = (DebitCard) cardDBHelper.getCard("debit", cardNumber);
                if (pin == debitCard.getPinNumber()) {
                    uuid = UUID.randomUUID();
                    return uuid;
                }
            } else {
                uuid = new UUID(0, 0);
                return uuid;
            }
        }
        uuid = new UUID(0, 0);
        return uuid;
    }

    //Same method but for credit card
    public UUID isValid(long cardNumber) {
        UUID uuid;
        for (int i = 0; i < 3; i++) {

            Card card = cardDBHelper.getCard("credit", cardNumber);
            if (card != null && cardNumber == card.getCardNumber()) {
                uuid = UUID.randomUUID();
                return uuid;
            } else {
                uuid = new UUID(0, 0);
                return uuid;
            }
        }
        uuid = new UUID(0, 0);
        return uuid;
    }
}
