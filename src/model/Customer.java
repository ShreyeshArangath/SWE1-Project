/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author cgonz
 */
public class Customer {
    public Integer userID;
    public String name;
    public String orders;
    public Integer phoneNumber;
    public Boolean isLoyalCustomer;
    private final String getName;
	
	public Customer(Integer userID, String name, String orders, Integer phoneNumber, Boolean isLoyalCustomer)
	{
		this.userID = userID;
		this.getName = name;
		this.orders = orders;
		this.phoneNumber = phoneNumber;
		this.isLoyalCustomer = isLoyalCustomer;
	}
	
	public Integer getuserID() 
	{
		return this.userID;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public String getOrders()
	{
		return this.orders;
	}
	
	public Integer getPhoneNumber() 
	{
		return this.phoneNumber;
	}
	
	public Boolean getisLoyalCustomer() 
	{
		return this.isLoyalCustomer;
	}
}
