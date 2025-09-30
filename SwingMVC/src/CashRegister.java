

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashRegister {
    private Map<String, Product> products;
    private List<Product> scannedItems;

    public CashRegister(String productsFile) {
        products = new HashMap<>();
        scannedItems = new ArrayList<>();
        loadProducts(productsFile);
    }

    private void loadProducts(String productsFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(productsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String upc = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2].replace("$", ""));
                    products.put(upc, new Product(upc, name, price));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading products file: " + e.getMessage());
        }
    }

    public boolean addItemByUPC(String upc) {
        Product p = products.get(upc);
        if (p != null) {
            scannedItems.add(p);
            return true;
        }
        return false;
    }

    public List<Product> getScannedItems() {
        return scannedItems;
    }

    public double getSubtotal() {
        return scannedItems.stream().mapToDouble(Product::getPrice).sum();
    }

    public static class Product {
        private String upc;
        private String name;
        private double price;

        public Product(String upc, String name, double price) {
            this.upc = upc;
            this.name = name;
            this.price = price;
        }

        public String getUpc() { return upc; }
        public String getName() { return name; }
        public double getPrice() { return price; }
    }
}
