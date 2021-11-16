/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbhelper;


import java.util.HashMap;
import java.util.List;
import java.util.Random;
import model.*;

/**
 *
 * @author shreyesh
 */
public class ProductDBHelper {

    private HashMap<String, RegularProduct> regularProducts;
    private HashMap<String, BulkProduct> bulkProducts;
    private final RegularProduct regularProductDefault = new RegularProduct("-1", "Default", 2.30, 0.0, 100, false);
    private final BulkProduct bulkProductDefault = new  BulkProduct("-1", "Default", 2.30, 0.0, 100, false, 0.0, 0.0);
            
    
    public boolean isDefault(BulkProduct product) {
        return bulkProductDefault.equals(product);
    }
    
    public boolean isDefault(RegularProduct product){
        return regularProductDefault.equals(product);
    }
            
    public Product getProduct(String productType, String productId) {
        if (productType.equalsIgnoreCase("BULK")) {
            BulkProduct product = this.bulkProducts.getOrDefault(productId, 
                    this.bulkProductDefault);
            return product;
        }

        if (productType.equalsIgnoreCase("REGULAR")) {
            return this.regularProducts.getOrDefault(productId, 
                    this.regularProductDefault);
        }

        return null;
    }

    public void readRegularProductDB() {
        ReadFileUtil r = new ReadFileUtil("regular-product.data");
        List<List<String>> data = r.readFile();
        this.regularProducts = new HashMap<>();

        // itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock
        data.remove(0);
        for (List<String> record : data) {
            String itemNumber = record.get(0);
            String itemDescription = record.get(1);
            Double retailPrice = Double.parseDouble(record.get(2));
            Double discountPercentage = Double.parseDouble(record.get(3));
            Integer availableUnits = Integer.parseInt(record.get(4));
            Boolean needsRestock = Boolean.parseBoolean(record.get(5));

            RegularProduct product = new RegularProduct(itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock);
            this.regularProducts.put(itemNumber, product);
        }

    }

    public void readBulkProductDB() {
        ReadFileUtil r = new ReadFileUtil("bulk-product.data");
        List<List<String>> data = r.readFile();

        this.bulkProducts = new HashMap<>();

        // itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock, pricePerUnit
        data.remove(0);
        for (List<String> record : data) {
            String itemNumber = record.get(0);
            String itemDescription = record.get(1);
            Double retailPrice = Double.parseDouble(record.get(2));
            Double discountPercentage = Double.parseDouble(record.get(3));
            Integer availableUnits = Integer.parseInt(record.get(4));
            Boolean needsRestock = Boolean.parseBoolean(record.get(5));
            Double pricePerUnit = Double.parseDouble(record.get(6));

            BulkProduct product = new BulkProduct(itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock, 0, pricePerUnit);
            this.bulkProducts.put(itemNumber, product);
        }

    }

    public static void main(String[] args) {
        ProductDBHelper db = new ProductDBHelper();
        db.readRegularProductDB();
        db.readBulkProductDB();
        System.out.println(db.getProduct("BULK", "201"));
        System.out.println(db.getProduct("BULK", "-1"));
        BulkProduct product = (BulkProduct) db.getProduct("BULK", "-1");
        System.out.println(db.isDefault(product));
    }
}
