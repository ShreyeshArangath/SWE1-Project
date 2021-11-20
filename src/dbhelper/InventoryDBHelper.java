/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;

import java.util.ArrayList;
import java.util.List;
//import java.util.Random;
import model.*;

/**
 *
 * @author matth
 */

public class InventoryDBHelper {
    
    private Inventory inventory;
    
    public Inventory getInventory(List<Product> product) {
        return this.inventory;
    }
    
    public void readInventoryDB() {
        ReadFileUtil r = new ReadFileUtil("Items.txt");
        List<List<String>> data = r.readFile();
        List<Product> products = new ArrayList<Product>();

        data.remove(0);
        for(List<String> info : data) {
            String itemNumber = info.get(0);
            String itemDescription = info.get(1);
            Double retailPrice = Double.parseDouble(info.get(2));
            Double discountPercentage = Double.parseDouble(info.get(3));
            Integer availableUnits = Integer.parseInt(info.get(4));
            Boolean needsRestock = Boolean.parseBoolean(info.get(5));
            
            Product product = new Product(itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock);
        }
        Inventory inventory = new Inventory(products);
        this.inventory = inventory;
    }
    
    public static void main(String[] args) {
        List<Product> product = new ArrayList<Product>();
        InventoryDBHelper db = new InventoryDBHelper();
        db.readInventoryDB();
        System.out.println(db.getInventory(product));
    }
}
