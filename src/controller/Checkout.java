/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;

/**
 *
 * @author shreyesh
 */
public class Checkout {

    private CustomerOrder customerOrder;
    private InventoryOrder inventoryOrder;
    private Customer customer;

    public Checkout(CustomerOrder order, Customer customer) {
        this.customerOrder = order;
        this.customer = customer;
    }

    public Checkout(InventoryOrder inventoryOrder, Customer customer) {
        this.inventoryOrder = inventoryOrder;
        this.customer = customer;
    }

    /*
    Loyalty Points: 1 pt = $1
    Precondition: Order has been processed and net total is calculated and customer is loyal
     */
    public Customer addLoyaltyCustomerCreditPoints() {
        if (customer.getIsLoyalCustomer()) {
            int orderTotal = (int) this.customerOrder.getSubTotal();
            customer.setLoyaltyPoints(orderTotal);
        }

        return this.customer;
    }

    public CustomerOrder execute(double salesTaxPercentage) {
        double total = 0;
        double totalDiscountAmount = 0;
        for (Product product : customerOrder.getItemsOrdered()) {
            double retailPrice = product.getRetailPrice();
            double discountAmount = product.getDiscountPercentage() * retailPrice;
            total += retailPrice;
            totalDiscountAmount += discountAmount;
        }

        customerOrder.setDiscountTotal(totalDiscountAmount);
        customerOrder.setSubTotal(total);
        customerOrder.setSalesTaxPercentage(salesTaxPercentage);
        customerOrder.getNetTotal();

        if (customer.getIsLoyalCustomer()) {
            this.customer = this.addLoyaltyCustomerCreditPoints();
        }

        return customerOrder;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    public CustomerOrder processPayment(PaymentMethod paymentMethod) {
        // TODO: Add paymentMethod pay implementation
        return customerOrder;
    }

}
