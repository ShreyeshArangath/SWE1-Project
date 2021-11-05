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
import java.util.UUID;
public class Check extends PaymentMethod{
    private UUID checkNumber;

    public Check(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid, UUID checkNumber) {
        super(amountDue, time, isSuccessful, amountPaid);
    }
    public void setCheckNumber(UUID checkNumber){
        this.checkNumber = checkNumber;
    }
    public UUID getCheckNumber(){
        return this.checkNumber;
    }
}
