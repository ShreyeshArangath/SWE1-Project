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
    private Bank bank;
    private Cash cash;
    private Card creditCard;
    private DebitCard debitCard;
    private Check check;
    LocalDateTime now;
    UUID uuid = UUID.randomUUID();

    public PaymentFlowManager(){
        this.bank = new Bank();
    }
    
    
    public Cash getCash() {
        return this.cash;
    }

    public Card getCreditCard() {
        return this.creditCard;
    }

    public DebitCard getDebitCard() {
        return this.debitCard;
    }

    public Check getCheck() {
        return this.check;
    }

    public boolean PaymentByCash(double amountDue, double amountPaid) {
        this.cash = new Cash(amountDue, now.now(), false, amountPaid);
        cash.setAmountDue();
        return cash.getIsSuccessful();
    }

    public UUID PaymentByCreditCard(long CardNumber, double amountDue, double amountPaid) {
        this.creditCard = new Card(amountDue, now.now(), false, amountPaid, CardNumber);
        return creditCard.authorizeCredit();
    }

    public UUID PaymentByDebitCard(long CardNumber, int pin, double amountDue, double amountPaid) {
        this.debitCard = new DebitCard(amountDue, now.now(), false, amountPaid, CardNumber, pin);
        return debitCard.authorizeDebit();

    }

    public boolean PaymentByCheck(double amountDue, double amountPaid) {
        CheckReader checkReader = new CheckReader();
        check = new Check(amountDue, now.now(), false, amountPaid, uuid);
        boolean result = checkReader.scanCheck(check);
        if (result == true) {
            check.setIsSuccessful(result);
            return result;
        }
        return result;
    }

}
