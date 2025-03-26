package org.example.Service;

import org.example.Entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    Product product = new Product();

    public double calculateSalesTax() {
        double taxRate = 10;  // 10% sales tax
        if (product.isExempt()) {
            taxRate = 0;  // Exempt items
        }
        if (product.isImported()) {
            taxRate += 5;  // Additional 5% for imported goods
        }
        return roundTax(taxRate * product.getPrice() / 100);
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20) / 20.0;
    }

    public double getFinalPrice() {
        return product.getPrice() + calculateSalesTax();
    }


}
