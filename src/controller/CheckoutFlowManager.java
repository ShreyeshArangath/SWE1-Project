/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbhelper.*;
import interfaces.*;
import java.util.Random;
import java.util.UUID;
import model.*;

/**
 *
 * @author shreyesh
 */
public class CheckoutFlowManager {

    private CustomerOrder order;
    private ProductDBHelper productDBHelper;
    final private String BULK = "BULK";
    final private String REGULAR = "REGULAR";

    private Checkout controller;
    final private double salesTaxPercentage = 12.1;
    
    public CheckoutFlowManager() {
        // Create a new order
        UUID orderNumber = UUID.randomUUID();
        this.order = new CustomerOrder(orderNumber);
        productDBHelper = new ProductDBHelper();
    }
    
    public void addRegularProduct(String productId) {
        RegularProduct product = (RegularProduct) productDBHelper.getProduct(REGULAR, productId);
        this.order.addToOrder(product);
    }
    
    public void addBulkProduct(String productId, Scale scale) {
        double weight = scale.weighItem();
        BulkProduct product = (BulkProduct) productDBHelper.getProduct(BULK, productId);
        product.setWeight(weight);
        this.order.addToOrder(product);
    }
    
    public CustomerOrder getOrder(){
        return this.order;
    }
    
    /**
     * 
     * @param customer
     * Precondition: Order must be populated with the relevant products
     * @return CustomerOrder object
     */
    public CheckoutFlowManager process(Customer customer, PaymentMethod paymentMethod) {
        this.controller = new Checkout(order, customer);
        this.controller.execute(this.salesTaxPercentage);
        this.controller.processPayment(paymentMethod);
        
        return this;
    }
    
     public static void main(String[] args) {
        CheckoutFlowManager manager = new CheckoutFlowManager();
        manager.addBulkProduct("201", new Scale());
        manager.addRegularProduct("101");
        System.out.println(manager.getOrder());
    }
}

