/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Random;
import java.util.UUID;
import model.*;
import factory.*;

/**
 *
 * @author shreyesh
 */
public class CheckoutFlowManager {

    private CustomerOrder order;
    final private int MAX_WEIGHT = 10;
    private Checkout controller;
    private final String DUMMY = "DUMMY";

    public CheckoutFlowManager() {
        this.initOrder();
    }

    private void initOrder() {
        UUID orderNumber = UUID.randomUUID();
        this.order.setOrderNumber(orderNumber);
    }

    private void initController() {
        customer = new CustomerFactory().getCustomer(DUMMY);
        Checkout checkoutController = new Checkout(order, customer);
    }
    
    public Product scanRegularProduct(String productId) {
        // TODO: Fetch Product from DB 
        String itemNumber = "";
        String itemDescription = "";
        Double retailPrice = 0.0;
        Double discountPercentage = 0.0;
        Integer availableUnits = 0;
        Boolean needsRestock = false;
        
        RegularProduct product = new RegularProduct(itemNumber,itemDescription,  retailPrice, discountPercentage, availableUnits, needsRestock);
        return product; 
    }
    
    public BulkProduct scanBulkProduct(String productId) {
        int weight = new Random().nextInt(MAX_WEIGHT);
            // TODO: Fetch Product from DB 
        String itemNumber = "";
        String itemDescription = "";
        Double retailPrice = 0.0;
        Double discountPercentage = 0.0;
        Integer availableUnits = 0;
        Boolean needsRestock = false;
        Double pricePerUnit = 0.0;
        
        BulkProduct product = new BulkProduct(itemNumber,itemDescription,  retailPrice, discountPercentage, availableUnits, needsRestock, pricePerUnit, weight);
        return product;
    }
    
    
    public CustomerOrder calculateOrderTotal() {
        
    }
}
