/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import model.CustomerOrder;

/**
 *
 * @author matth
 */

public class CustomerOrderReceiptPrinter {
    
    public void outputInfo(CustomerOrder order) {
        System.out.println("***Receipt***\n");
        for(int i = 0; i < order.getItemsOrdered().size(); i++) {
            System.out.print(order.getItemsOrdered().get(i).getItemDescription() + "\t");
            System.out.print(order.getItemsOrdered().get(i).getRetailPrice() + "\n");
        }
    }
}
