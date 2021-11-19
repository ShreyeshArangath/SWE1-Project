/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shreyesh
 */
public class RegularProduct extends Product{
    
    public RegularProduct(String itemNumber, String itemDescription, Double retailPrice, Double discountPercentage, int availableUnits, boolean needsRestock) {
        super(itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock);
    }
    
}
