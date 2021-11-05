/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cgonz
 */
public class LoyaltyCustomer extends Customer{
	Integer memberPin;
	Integer loyaltyPoints;

    public LoyaltyCustomer(Integer userID, String name, String orders, Integer phoneNumber, Boolean isLoyalCustomer, Integer memberPin, Integer loyaltyPoints) {
        super(userID, name, orders, phoneNumber, isLoyalCustomer);
                this.memberPin = memberPin;
                this.loyaltyPoints = loyaltyPoints;
    }
    	
	public Integer getMemberPin() 
	{
		return this.memberPin;
	}

	public Integer getLoyaltyPoints() 
	{
		return this.loyaltyPoints;
	}
}
