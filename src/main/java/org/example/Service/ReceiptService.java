package org.example.Service;

import org.example.Entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptService {

    private List<Product> products;

    public ReceiptService() {
        products = new ArrayList<>();
    }

    // Add a product to the basket
    public void addProduct(Product product) {
        products.add(product);
    }

    // Calculate total sales tax and total price
    public double calculateTotalSalesTax() {
        double totalTax = 0;
        for (Product product : products) {
            totalTax += product.calculateSalesTax();
        }
        return roundToTwoDecimalPlaces(totalTax);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getFinalPrice();
        }
        return roundToTwoDecimalPlaces(totalPrice);
    }

    // Format prices to 2 decimal places
    private double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // Print the receipt details
    public void printReceipt() {
        double totalTax = calculateTotalSalesTax();
        double totalPrice = calculateTotalPrice();

        for (Product product : products) {
            System.out.println(product.getName() + " : " + roundToTwoDecimalPlaces(product.getFinalPrice()));
        }
        System.out.println("Sales Taxes : " + totalTax);
        System.out.println("Total : " + totalPrice);
    }
}
