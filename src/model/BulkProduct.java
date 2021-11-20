/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shreyesh
 */
public class BulkProduct extends Product {

    double weight;
    double pricePerUnit;

    public BulkProduct(String itemNumber,
            String itemDescription,
            Double retailPrice, Double discountPercentage,
            int availableUnits,
            boolean needsRestock,
            double weight,
            double pricePerUnit) {
        super(itemNumber, itemDescription, retailPrice, discountPercentage, availableUnits, needsRestock);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }
    

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    private double _calculatePrice() {
        return this.pricePerUnit * this.weight;
    }

    @Override
    public Double getRetailPrice() {
        this.setRetailPrice(this._calculatePrice());
        return this.retailPrice;
    }
}
