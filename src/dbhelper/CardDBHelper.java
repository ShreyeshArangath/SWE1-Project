/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import model.*;

public class CardDBHelper {
    private HashMap<Long, Card> creditCards;
    private HashMap<Long, Card> debitCards;
    
    public CardDBHelper(){
        this.readCreditCardDB();
        this.readDebitCardDB();
    }
    
    public Long getRandomDebitCardNumber() {
        int length = debitCards.keySet().toArray().length;
        Random rand = new Random();
        int index = rand.nextInt(length);
       
        
        List<Long> cc= new ArrayList<>();
        cc.add((Long) debitCards.keySet().toArray()[index]);
        cc.add(0000000000000000L);
        index = rand.nextInt(cc.size());
        return cc.get(index);
    }
    
     public Long getRandomCreditCardNumber() {
        int length = creditCards.keySet().toArray().length;
        Random rand = new Random();
        int index = rand.nextInt(length);
        
        List<Long> cc= new ArrayList<>();
        cc.add((Long) creditCards.keySet().toArray()[index]);
        cc.add(0000000000000000L);
        index = rand.nextInt(cc.size());
        return cc.get(index);
    }
    
    
    public Card getCard(String cardType, long cardNumber){
        if(cardType.equalsIgnoreCase("Credit")){
            Card card = this.creditCards.get(cardNumber);
            return card;
        }
        if(cardType.equalsIgnoreCase("Debit")){
            
            return this.debitCards.get(cardNumber);
        }
        return null;
    }
    
    public void readCreditCardDB(){
        ReadFileUtil r = new ReadFileUtil("credit-card.data");
        List<List<String>> data = r.readFile();
        this.creditCards = new HashMap<>();
        
        //cardNumber
        data.remove(0);
        for(List<String> record: data){
            long CardNumber = Long.valueOf(record.get(0));
            
            Card card = new Card();
            card.setCardNumber(CardNumber);
            this.creditCards.put(CardNumber, card);
        }
    }
    
    public void readDebitCardDB(){
        ReadFileUtil r = new ReadFileUtil("debit-card.data");
        List<List<String>> data = r.readFile();
        
        this.debitCards = new HashMap<>();
        
        //cardNumber, pin
        data.remove(0);
        for(List<String> record: data){
            long cardNumber = Long.valueOf(record.get(0));
            int pin = Integer.valueOf(record.get(1));
            DebitCard card = new DebitCard();
            card.setCardNumber(cardNumber);
            card.setPinNumber(pin);
            
            this.debitCards.put(cardNumber, card);
        }
    }
    
    
        public static void main(String[] args){
            CardDBHelper db = new CardDBHelper();
            db.readCreditCardDB();
            db.readDebitCardDB();
            System.out.println(db.getCard("Credit", 4567456745674567L));
            System.out.println(db.getCard("Debit", 1234123412341234L));
            Card card = (Card) db.getCard("Credit", 4567456745674567L);            
        }
    
    
}
