/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cgonz
 */
public class Customer {

    public String userID;
    public String name;
    public Integer phoneNumber;
    public Boolean isLoyalCustomer;
    private Integer memberPin;
    private Integer loyaltyPoints;
    final private Integer DOES_NOT_EXIST = -1;

    // Regular Customer
    public Customer(String userID,
            String name,
            Integer phoneNumber,
            Boolean isLoyalCustomer) {
        this.userID = userID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isLoyalCustomer = isLoyalCustomer;
    }

    // Loyalty Customer
    public Customer(String userID,
            String name,
            Integer phoneNumber,
            Boolean isLoyalCustomer,
            Integer memberPin,
            Integer loyaltyPoints) {
        this.userID = userID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isLoyalCustomer = isLoyalCustomer;
        this.memberPin = memberPin;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserId(String userId) {
        this.userID = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIsLoyaltyCustomer(Boolean isLoyaltyCustomer) {
        this.isLoyalCustomer = isLoyaltyCustomer;
    }

    public Boolean getIsLoyalCustomer() {
        return this.isLoyalCustomer;
    }

    public Integer getMemberPin() {
        if (this.isLoyalCustomer) {
            return this.memberPin;
        }
        return DOES_NOT_EXIST;
    }

    public Integer getLoyaltyPoints() {
        if (this.isLoyalCustomer) {
            return this.loyaltyPoints;
        }
        return DOES_NOT_EXIST;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (this.isLoyalCustomer) {
            this.loyaltyPoints = loyaltyPoints;
        }

    }

}
