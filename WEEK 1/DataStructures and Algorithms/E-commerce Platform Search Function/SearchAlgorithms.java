import java.util.Arrays;

public class SearchAlgorithms {

   
    public static int linearSearch(Product[] products, String targetProductId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId().equals(targetProductId)) {
                return i; 
            }
        }
        return -1; 
    }

    
    public static int binarySearch(Product[] products, String targetProductId) {
        
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
        
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetProductId);

            if (comparison == 0) {
                return mid; 
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Shirt", "Clothing"),
            new Product("P004", "Shoes", "Footwear")
        };

        // Linear Search
        System.out.println("Linear Search:");
        int index = linearSearch(products, "P003");
        if (index != -1) {
            System.out.println("Product found: " + products[index]);
        } else {
            System.out.println("Product not found.");
        }

        // Binary Search
        System.out.println("Binary Search:");
        index = binarySearch(products, "P002");
        if (index != -1) {
            System.out.println("Product found: " + products[index]);
        } else {
            System.out.println("Product not found.");
        }
    }
}

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
