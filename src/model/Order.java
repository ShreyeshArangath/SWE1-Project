/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author matth
 */
public class Order {

    private UUID orderNumber;
    PaymentMethod paymentMethod;
    List<Product> itemsOrdered;
    private double subTotal;
    public double netTotal;
    private double discountTotal;
    private boolean hasPaid;

    public Order(UUID orderNumber) {
        this.orderNumber = orderNumber;
        this.itemsOrdered = new ArrayList<>();
    }

    public Order(UUID orderNumber, List<Product> itemsOrdered) {
        this.orderNumber = orderNumber;
        this.itemsOrdered = itemsOrdered;
    }
    public Order(UUID orderNumber,
            PaymentMethod paymentMethod,
            List<Product> itemsOrdered,
            double subTotal,
            double netTotal,
            double discountTotal,
            boolean hasPaid) {
        this.orderNumber = orderNumber;
        this.paymentMethod = paymentMethod;
        this.itemsOrdered = itemsOrdered;
        this.discountTotal = discountTotal;
        this.subTotal = subTotal;
        this.hasPaid = hasPaid;
    }

    public List<Product> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setOrderNumber(UUID orderNumber) {
        this.orderNumber = orderNumber;
    }

    public UUID getOrderNumber() {
        return this.orderNumber;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal() {
        return this.subTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public double setNetTotal() {
        return this.netTotal;
    }

    public void setDiscountTotal(double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public double getDiscountTotal() {
        return this.discountTotal;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public boolean getHasPaid() {
        return this.hasPaid;
    }

    public List<Product> addToOrder(Product product) {
        boolean result = this.itemsOrdered.add(product);

        if (result) {
            System.out.println("Successfully added to list");
        }
        
        return this.itemsOrdered;
    }

}
