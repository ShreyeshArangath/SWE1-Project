/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dbhelper.*;
import interfaces.*;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
        productDBHelper.readBulkProductDB();
        productDBHelper.readRegularProductDB();
    }

    public void addRegularProduct(String productId) {
        RegularProduct product = (RegularProduct) productDBHelper.getProduct(REGULAR, productId);
        this.order.addToOrder(product);
        System.out.println(this.order.getItemsOrdered().get(this.order.getItemsOrdered().size() - 1).itemDescription);
    }

    public String getRandomRegularItem() {
        int length = productDBHelper.getRegularProducts().keySet().toArray().length;
        Random rand = new Random();
        int index = rand.nextInt(length);
        return (String) productDBHelper.getRegularProducts().keySet().toArray()[index];
    }

    public Product getProduct(String productId) {
        return this.productDBHelper.getProduct(REGULAR, productId);
    }

    public void addBulkProduct(String productId, Scale scale) {
        double weight = scale.weighItem();
        BulkProduct product = (BulkProduct) productDBHelper.getProduct(BULK, productId);
        product.setWeight(weight);
        this.order.addToOrder(product);
    }

    public CustomerOrder getOrder() {
        return this.order;
    }

    public PaymentFlowManager getPaymentFlowManager() {
        return this.controller.paymentFlowManager;
    }

    /**
     *
     * @param customer Precondition: Order must be populated with the relevant
     * products
     * @return CustomerOrder object
     */
    public CheckoutFlowManager processOrder(Customer customer) {
        this.controller = new Checkout(order, customer);
        this.controller.execute(this.salesTaxPercentage);

        return this;
    }

    public double processCashPayment(double amountDue, double amountPaid) {
        if (this.controller.paymentFlowManager.PaymentByCash(amountDue, amountPaid)) {
            return this.controller.paymentFlowManager.getCash().getChange();
        }
        return Float.MAX_VALUE;
    }

    public UUID processCreditCardPayment(Long cardNo, double amountDue, double amountPaid) {
        return this.controller
                .paymentFlowManager
                .PaymentByCreditCard(cardNo, amountDue, amountPaid);
    }

    public UUID processDebitCardPayment(Long cardNo, int pin, double amountDue, double amountPaid) {
        return this.controller
                .paymentFlowManager
                .PaymentByDebitCard(cardNo, pin, amountDue, amountPaid);
    }

    public UUID processCheck(double amountDue, double amountPaid) {
        if (this.controller.paymentFlowManager.PaymentByCheck(amountDue, amountPaid)) {
            return this.controller
                    .paymentFlowManager
                    .getCheck()
                    .getCheckNumber();
        }
        return null;
    }

    public void updateInventory() {
        for (Product product : this.order.getItemsOrdered()) {
            if (this.productDBHelper.getRegularProducts().containsKey(product.itemNumber)) {
                RegularProduct regProd = this.productDBHelper
                        .getRegularProducts()
                        .get(product.itemNumber);
                regProd.availableUnits -= 1;
                this.productDBHelper
                        .getRegularProducts()
                        .put(product.itemNumber, regProd);
            } else if (this.productDBHelper.getBulkProducts().containsKey(product.itemNumber)) {
                BulkProduct bulkProd = this.productDBHelper
                        .getBulkProducts()
                        .get(product.itemNumber);
                bulkProd.availableUnits -= 1;
                this.productDBHelper
                        .getBulkProducts()
                        .put(product.itemNumber, bulkProd);
            }
        }

        this.productDBHelper.updateDB();
    }

    public static void main(String[] args) {
        CheckoutFlowManager manager = new CheckoutFlowManager();
        manager.addBulkProduct("201", new Scale());
        manager.addRegularProduct("101");
        System.out.println(manager.getOrder());
    }
}
