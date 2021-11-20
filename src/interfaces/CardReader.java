/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package interfaces;

/**
 *
 * @author User
 */
import java.util.UUID;
import model.Bank;
import model.Card;
public class CardReader {
    Bank bank = new Bank();
    
    /*
    Returns authorization code if valid
    uuid w all zeros if not valid
    */
    public UUID enterCreditCard(Card creditCard)
    {
        return bank.isValid(creditCard.getCardNumber());
    }
    /*public UUID enterDebitCard(Card debitCard)
    {
        return bank.isValid(debitCard.getCardNumber(),debitCard.getPinNumber());
    }*/
}
