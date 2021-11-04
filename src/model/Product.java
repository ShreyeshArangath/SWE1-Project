/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shreyesh
 */
public class Product {
    public String itemNumber; 
    public String itemDescription;
    public double retailPrice; 
    public double discountPercentage; 
    public int availableUnits; 
    public boolean needsRestock;
    
    public Product(String itemNumber, String itemDescription, double retailPrice, 
            double discountPercentage, int availableUnits, boolean needsRestock){
        this.itemDescription = itemDescription;
        this.itemNumber = itemNumber; 
        this.retailPrice = retailPrice; 
        this.discountPercentage = discountPercentage; 
        this.availableUnits = availableUnits; 
        this.needsRestock = needsRestock;
    }
    
    public String getItemNumber(){
        return this.itemNumber;
    }
    
    public void setItemNumber(String itemNumber) {
       this.itemNumber = itemNumber; 
    } 
    
    public String getItemDescription(){
        return this.itemDescription;
    }
    
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
     
    public double getRetailPrice () {
        return this.retailPrice;
    }
    
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice; 
    }
    
    public double getDiscountPercentage(){
        return this.discountPercentage;
    }
    
    public void setDiscountPercentage(double discountPercentage){
        this.discountPercentage = discountPercentage;
    }
    
    public int getAvailableUnits() {
        return this.getAvailableUnits();
    }
    
    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits; 
    }
    
    public boolean getNeedsRestock(){
        return this.needsRestock;
    }
    
    public void setNeedsRestock(boolean needsRestock) {
        this.needsRestock = needsRestock;
    }
    
}
