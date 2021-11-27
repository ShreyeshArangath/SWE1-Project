/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbhelper.ProductDBHelper;
import java.util.TimerTask;

/**
 *
 * @author shreyesh
 */
public class InventoryRestockTask {
    
    public static TimerTask getTask() {
        return new TimerTask () {
        @Override
        public void run () {
            ProductDBHelper db = new ProductDBHelper();
            InventoryRestockManager inventoryRestockManager = new InventoryRestockManager(db);
            inventoryRestockManager.readDB();
            inventoryRestockManager.restockInventory();
            
        }
};
    }
}
