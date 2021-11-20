/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author User
 */
public class DebitCard extends Card {
    private int pin;
    
    //Constructor for debit card
    public DebitCard(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid, long cardNumber, int pin){
        super(amountDue, time, isSuccessful, amountPaid, cardNumber);
        this.pin = pin;
    }
    public DebitCard(){
        
    };
    
    public void setPinNumber(int pin){
        this.pin = pin;
    }
    public int getPinNumber(){
        return this.pin;
    }
    
    /*
    sends an authorization code if valid, all zeros if not
    */
    public UUID authorizeDebit()
    {
        Bank bank = new Bank();
        return bank.isValid(this.cardNumber,this.pin);
    }
}
