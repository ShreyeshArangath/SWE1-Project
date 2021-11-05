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
    public Double retailPrice; 
    public Double discountPercentage; 
    public Integer availableUnits; 
    public Boolean needsRestock;
    
    public Product(String itemNumber, String itemDescription, Double retailPrice, 
            Double discountPercentage, int availableUnits, boolean needsRestock){
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
    
     public String getItemDescription(){
        return this.itemDescription;
    }
    
}
