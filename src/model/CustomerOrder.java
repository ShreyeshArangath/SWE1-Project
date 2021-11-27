/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package model;*/
package model;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author matth
 */

public class CustomerOrder extends Order {

    private double salesTaxPercentage;

    public CustomerOrder(UUID orderNumber, PaymentMethod paymentMethod, List<Product> itemsOrdered, double subTotal, double netTotal, double discountTotal, boolean hasPaid, double salesTaxPercentage) {
        super(orderNumber, paymentMethod, itemsOrdered, discountTotal, discountTotal, discountTotal, hasPaid);
        this.salesTaxPercentage = salesTaxPercentage;
    }

    public CustomerOrder(UUID orderNumber) {
        super(orderNumber);
    }

    public void processOrder(){
        double total = 0;
        double totalDiscountAmount = 0;
        for (Product product : this.getItemsOrdered()) {
            
            double retailPrice = product.getRetailPrice();
            double discountAmount = product.getDiscountPercentage()/100 * retailPrice;
            total = total + retailPrice;
            totalDiscountAmount = totalDiscountAmount + discountAmount;
        }

        this.setDiscountTotal(totalDiscountAmount);
        this.setSubTotal(total);
        this.setSalesTaxPercentage(salesTaxPercentage);
        this.setNetTotal();
    }
    private double _calculateNetTotal() {
        return this.getSubTotal() - this.getDiscountTotal() + this.salesTaxPercentage/100 * this.getSubTotal();
    }

    public void setSalesTaxPercentage(double salesTaxPercentage) {
        this.salesTaxPercentage = salesTaxPercentage;
    }

    public double getSalesTaxPercentage() {
        return this.salesTaxPercentage;
    }

    @Override
    public double setNetTotal() {
        this.netTotal = _calculateNetTotal();
        return this.netTotal;
    }
}
