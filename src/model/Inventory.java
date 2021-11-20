/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author matth
 */

public class Inventory {
    public List<Product> itemsAvailable;
    
    //product below threshold requires restock
    static int threshold = 25;
    
    public Inventory(List<Product> itemsAvailable) {
        this.itemsAvailable = itemsAvailable;
    }
    
    
    
    public void subItemsOrdered(List<Product> itemsOrdered) {
        int i, j;
        
        //iterates through itemsAvailable list and itemsOrdered list to check if item numbers are equal. If so, subtract the units and set the new value to availableUnits
        for(i = 0; i < this.itemsAvailable.size(); i++) {
            for(j = 0; j < itemsOrdered.size(); j++) {
                if(this.itemsAvailable.get(i).getItemNumber().equals(itemsOrdered.get(j).getItemNumber())) {
                    int units = this.itemsAvailable.get(i).getAvailableUnits();
                    units -= 1;
                    this.itemsAvailable.get(i).setAvailableUnits(units);
                }
            }
        }
    }
    
//    public void updateInventory(List <Product> products) {
//        //clear the file to update inventory available
//        try {
//            FileWriter fw = new FileWriter("Items.txt", false);
//            PrintWriter pw = new PrintWriter(fw, false);
//            pw.flush();
//            
//            for(int i = 0; i < this.itemsAvailable.size(); i++) {
//                pw.print(this.itemsAvailable.get(i).getItemNumber() + " ");
//                pw.print(this.itemsAvailable.get(i).getItemDescription() + " ");
//                pw.print(this.itemsAvailable.get(i).getRetailPrice() + " ");
//                pw.print(this.itemsAvailable.get(i).getDiscountPercentage() + " ");
//                pw.print(this.itemsAvailable.get(i).getAvailableUnits() + " ");
//                pw.print(this.itemsAvailable.get(i).getNeedsRestock() + "\n");
//                pw.close();
//            }
//        }
//        catch (IOException exception) {
//            System.out.println("Error!");
//        }
//    }
}