/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Cash extends PaymentMethod{
    
    public Cash(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid) {
        super(amountDue, time, isSuccessful, amountPaid);
    }
    
}
