/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
<<<<<<< HEAD

/**
 *
 * @author User
 */
public class Card {
=======
import java.time.LocalDateTime;
import java.util.UUID;
public class Card extends PaymentMethod{
    private UUID cardNumber;

    public Card(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid, UUID cardNumber) {
        super(amountDue, time, isSuccessful, amountPaid);
    }
    
    public void setCardNumber(UUID cardNumber){
        this.cardNumber = cardNumber;
    }
    public UUID getCardNumber(){
        return this.cardNumber;
    }
>>>>>>> 2bd5f4ba79c6a19349d18f461694a2ec8d276418
    
}
