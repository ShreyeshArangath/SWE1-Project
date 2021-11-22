/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbhelper.*;
import interfaces.*;
import java.util.ArrayList;
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
    private ProductDBHelper productDBHelper;

    // ASSUMPTION: Threshold value and restock value are constant for each product 
    private int THRESHOLD = 5;
    private int RESTOCK_VALUE = 20;

    private Inventory controller;

    public InventoryRestockManager(ProductDBHelper productDBHelper) {
        this.product = product;
        this.productDBHelper = productDBHelper;
        inventoryDBHelper = new InventoryDBHelper();
    }

    public InventoryOrder getInventoryOrder() {
        return this.order;
    }

    public List<Product> restockInventory() {
        List<Product> restockedProducts = new ArrayList<>();
        for (RegularProduct regProd : this.productDBHelper.getRegularProducts().values()) {
            if (regProd.availableUnits <= THRESHOLD) {
                regProd.availableUnits = RESTOCK_VALUE;
                restockedProducts.add(regProd);
            }
        }

        for (BulkProduct bulkProd : this.productDBHelper.getBulkProducts().values()) {
            if (bulkProd.availableUnits <= THRESHOLD) {
                bulkProd.availableUnits = RESTOCK_VALUE;
                restockedProducts.add(bulkProd);
            }
        }

        return restockedProducts;
    }

    public static void main(String[] args) {
        ProductDBHelper db = new ProductDBHelper();
        db.readBulkProductDB();
        db.readRegularProductDB();
        InventoryRestockManager manager = new InventoryRestockManager(db);
        System.out.println(manager.getInventoryOrder());
    }
}
