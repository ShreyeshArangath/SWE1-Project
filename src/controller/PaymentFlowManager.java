/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author User
 */
import dbhelper.*;
import interfaces.*;
import java.util.Random;
import java.util.UUID;
import java.time.LocalDateTime;
import model.*;
public class PaymentFlowManager {
    private PaymentMethod paymentMethod;
    private Cash cash;
    private Card creditCard;
    private DebitCard debitCard;
    private Check check;
    LocalDateTime now;
    
    public double PaymentByCash(double amountDue, double amountPaid){
        this.cash = new Cash(amountDue, now.now(), false, amountPaid);
        return cash.getChange();
    }
    
    public void PaymentByCreditCard(){
        
    }
    
    public void PaymentByDebitCard(){
        
    }
    public void PaymentByCheck(){
        
    }
    
    
}
