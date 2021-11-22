/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.*;

/**
 *
 * @author matth
 */
public class InventoryDBHelper {

    private Inventory inventory;
    
    public InventoryDBHelper() {
        readInventoryDB();
    }
    
    public Inventory getInventory(List<Product> product) {
        return this.inventory;
    }

    public void readInventoryDB() {
        ProductDBHelper dbhelper = new ProductDBHelper();
        dbhelper.readBulkProductDB();
        dbhelper.readRegularProductDB();
        HashMap<String, RegularProduct> regularProduct = dbhelper.getRegularProducts();
        HashMap<String, BulkProduct> bulkProduct = dbhelper.getBulkProducts();

        List<Product> products = new ArrayList<>();
        for (Map.Entry<String, RegularProduct> regular : regularProduct.entrySet()) {
            products.add(regular.getValue());
        }

        for (Map.Entry<String, BulkProduct> bulk : bulkProduct.entrySet()) {
            products.add(bulk.getValue());
        }

        this.inventory = new Inventory(products);

    }

    public static void main(String[] args) {
        List<Product> product = new ArrayList<Product>();
        InventoryDBHelper db = new InventoryDBHelper();
        db.getInventory(product).itemsAvailable.forEach(x -> {
            System.out.println(x.getItemDescription());
        });
    }
}
