package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Product {
    private String name;
    private double price;
    private boolean isImported;
    private boolean isExempt;

    public Product() {
    }

    public Product(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public double calculateSalesTax() {
        double taxRate = 10;  // 10% sales tax
        if (isExempt) {
            taxRate = 0;  // Exempt items
        }
        if (isImported) {
            taxRate += 5;  // Additional 5% for imported goods
        }
        return roundTax(taxRate * price / 100);
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20) / 20.0;
    }

    public double getFinalPrice() {
        return price + calculateSalesTax();
    }



}
