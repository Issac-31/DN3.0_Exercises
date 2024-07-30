import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {
    private HashMap<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
            System.out.println("Product updated: " + updatedProduct);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            Product removedProduct = inventory.remove(productId);
            System.out.println("Product removed: " + removedProduct);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: \n1. Add Product \n2. Update Product \n3. Delete Product \n4. Display Inventory \n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:

                    System.out.println("Enter product details (ID, Name, Quantity, Price): ");
                    String id = scanner.nextLine();
                    String name = scanner.nextLine();
                    int quantity = scanner.nextInt();
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    ims.addProduct(new Product(id, name, quantity, price));
                    break;
                case 2:
                    System.out.println("Enter product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.println("Enter new product details (ID, Name, Quantity, Price): ");
                    String newId = scanner.nextLine();
                    String newName = scanner.nextLine();
                    int newQuantity = scanner.nextInt();
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    ims.updateProduct(updateId, new Product(newId, newName, newQuantity, newPrice));
                    break;
                case 3:
                    System.out.println("Enter product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ims.deleteProduct(deleteId);
                    break;
                case 4:
                    ims.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
