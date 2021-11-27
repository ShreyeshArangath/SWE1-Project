package dbhelper;


import dbhelper.ReadFileUtil;
import dbhelper.WriteFileUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import model.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author shreyesh
 */
public class InventoryOrderDBHelper {

    public void updateInventoryOrderDB(InventoryOrder inventoryOrder) {
        WriteFileUtil wfu = new WriteFileUtil("inventory-orders.data");
        List<String> columnData = List.of("orderNumber",
                "itemNumber",
                "itemDescription",
                "quantityRestocked");
        List<List<String>> data = new ArrayList<>();
        for (Product product : inventoryOrder.getItemsOrdered()) {
            List<String> row = new ArrayList<>();
            row.add(inventoryOrder.getOrderNumber().toString());
            row.add(product.getItemNumber());
            row.add(product.getItemDescription());
            row.add(Integer.toString(20));
            data.add(row);
        }
        wfu.write(columnData, data);
    }
}
