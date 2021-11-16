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
public class CustomerOrder extends Order {
    private double salesTaxPercentage;
    public CustomerOrder(UUID orderNumber, PaymentMethod paymentMethod, List<Product> itemsOrdered, double subTotal, double netTotal, double discountTotal, boolean hasPaid, double salesTaxPercentage) {
		super(orderNumber, paymentMethod, itemsOrdered, discountTotal, discountTotal, discountTotal, hasPaid);
                this.salesTaxPercentage = salesTaxPercentage;
	}
   
        private double _calculateNetTotal() {
            return this.getSubTotal() - this.getDiscountTotal() - this.salesTaxPercentage * this.getSubTotal();
        }
        
        public void setSalesTaxPercentage(double salesTaxPercentage){
           this.salesTaxPercentage = salesTaxPercentage;
        }
        
        public double getSalesTaxPercentage(){
            return this.salesTaxPercentage;
        }
        
        @Override public double getNetTotal(){
            this.setNetTotal(_calculateNetTotal());
            return this.getNetTotal();
        }
}
