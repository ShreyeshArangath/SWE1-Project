/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/*
Flow: the customer enters a card into the credit/debit card reader
Debit:
a customer enters a PIN to the card reader 
a message is sent to the appropriate card authorization center 
the card request is either accepted or rejected
if accepted, an authorization code is returned
the card number and authorization code are printed on the receipt 
if a credit or debit card is not accepted and no other payment is offered, the order is cancelled
*/
import java.time.LocalDateTime;
import java.util.UUID;
public class Card extends PaymentMethod{
    public long cardNumber;
    //private int pin;

    //Constructor for credit card
    public Card(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid, long cardNumber) {
        super(amountDue, time, isSuccessful, amountPaid);
        this.cardNumber = cardNumber;
    }
    
    public Card(){
        
    };
    
    public void setCardNumber(long cardNumber){
        this.cardNumber = cardNumber;
    }
    public long getCardNumber(){
        return this.cardNumber;
    }
    
    
    /*
    sends an authorization code if valid, all zeros if not
    */
    
    public UUID authorizeCredit(){
        Bank bank = new Bank();
        return bank.isValid(this.cardNumber);
    }
 
}
