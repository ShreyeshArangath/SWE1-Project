/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author matth
 */
public class InventoryOrder extends Order {

    OrderTimer timer;
    Integer quantityRestocked;

    public InventoryOrder(UUID orderNumber, List<Product> itemsOrdered) {
        super(orderNumber, itemsOrdered);
    }
    
    public InventoryOrder(UUID orderNumber, PaymentMethod paymentMethod, List<Product> itemsOrdered, double subTotal, double netTotal, double discountTotal, boolean hasPaid) {
        super(orderNumber, paymentMethod, itemsOrdered, discountTotal, discountTotal, discountTotal, hasPaid);
    }

    public void setInventoryOrder() {
        timer = new OrderTimer(300);
        //System.out.println("Inventory order will be sent to supplier in 5 minutes.");
    }
    
}
