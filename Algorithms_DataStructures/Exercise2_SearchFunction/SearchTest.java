package Algorithms_DataStructures.Exercise2_SearchFunction;
import java.util.Arrays;

public class SearchTest {
    // Linear Search
    public static int linearSearch(Product[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (on sorted array)
    public static int binarySearch(Product[] products, String target) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(target);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Apparel"),
            new Product(3, "Book", "Stationery"),
            new Product(4, "Phone", "Electronics")
        };

        // Sort products by productName for binary search
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));

        String target = "Book";

        int indexLinear = linearSearch(products, target);
        int indexBinary = binarySearch(products, target);

        System.out.println("Linear Search found at index: " + indexLinear);
        System.out.println("Binary Search found at index: " + indexBinary);
    }
}
