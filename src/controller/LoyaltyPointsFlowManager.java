/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.*; 

/**
 *
 * @author shreyesh
 */
public class LoyaltyPointsFlowManager {
    private Customer customer = null;
    
    public LoyaltyPointsFlowManager() {
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    public Customer addPointsToAccount(int newPoints) {
        int originalPoints = this.customer.getLoyaltyPoints();
        this.customer.setLoyaltyPoints(originalPoints + newPoints);
        
        return customer;
    } 
   

}
