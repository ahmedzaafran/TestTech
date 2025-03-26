package org.example;

import org.example.Entity.Product;
import org.example.Service.ReceiptService;

public class Main {

public static void main(String[] args) {
    // Input 1:
    ReceiptService receipt1 = new ReceiptService();
    receipt1.addProduct(new Product("book", 12.49, false, true));
    receipt1.addProduct(new Product("music CD", 14.99, false, false));
    receipt1.addProduct(new Product("chocolate bar ", 0.85, false, true));
    receipt1.printReceipt();

    // Input 2:
    System.out.println("\n--- Input 2 ---");
    ReceiptService receipt2 = new ReceiptService();
    receipt2.addProduct(new Product("imported box of chocolates", 10.00, true, true));
    receipt2.addProduct(new Product("imported bottle of perfume", 47.50, true, false));
    receipt2.printReceipt();

    // Input 3:
    System.out.println("\n--- Input 3 ---");
    ReceiptService receipt3 = new ReceiptService();
    receipt3.addProduct(new Product("imported bottle of perfume", 27.99, true, false));
    receipt3.addProduct(new Product("bottle of perfume", 18.99, false, false));
    receipt3.addProduct(new Product("packet of headache pills", 9.75, false, true));
    receipt3.addProduct(new Product("imported box of chocolates", 11.25, true, true));
    receipt3.printReceipt();
}
}