/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbhelper.*;
import interfaces.*;
import java.util.List;
import model.*;

/**
 *
 * @author matth
 */

public class InventoryRestockManager {
    private List<Product> product;
    private InventoryOrder order;
    private InventoryDBHelper inventoryDBHelper;
    
    private Inventory controller;
    
    public InventoryRestockManager() {
        this.product = product;
        inventoryDBHelper = new InventoryDBHelper();
//        this.inventory = inventoryDBHelper.getInventory();
    }
    
    public InventoryOrder getInventoryOrder() {
        return this.order;
    }
    
    public InventoryRestockManager process (CustomerOrder order, Product product) {
        this.controller = new Inventory(this.product);
        return this;
    }
    
    public static void main(String[] args) {
        InventoryRestockManager manager = new InventoryRestockManager();
        System.out.println(manager.getInventoryOrder());
    }
}
