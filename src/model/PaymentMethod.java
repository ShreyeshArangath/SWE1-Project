/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
import java.time.LocalDateTime;
public class PaymentMethod {
    private double amountDue;
    private LocalDateTime time;
    private boolean isSuccessful;
    private double amountPaid;
    
    public PaymentMethod(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid){
       this.amountDue = amountDue;
       this.time = time; 
       this.isSuccessful = isSuccessful; 
       this.amountPaid = amountPaid;
    }
    
    public void setAmountDue(double amountDue){
        this.amountDue = amountDue;
    }
    public double getAmountDue(){
        return this.amountDue;
    }
    public void setTime(LocalDateTime time){
        this.time=time;
    }
    public LocalDateTime getTime(){
        return this.time;
    }
    public void setIsSuccessful(boolean isSuccessful){
        this.isSuccessful = isSuccessful;      
    }
    public boolean getIsSuccessful(){
        return this.isSuccessful;
    }
    public void setAmountPaid(double amountPaid){
        this.amountPaid= amountPaid;
    }
    public double getAmountPaid(){
        return this.amountPaid;
    }
    
}
