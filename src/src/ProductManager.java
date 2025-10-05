import java.util.ArrayList;

public class ProductManager {
    public ArrayList<Product> products = new ArrayList();

    public ProductManager() {
        this.addSampleProducts();
    }

    private void addSampleProducts() {
        this.products.add(new Product(1, "Laptop", 999.99, 5));
        this.products.add(new Product(2, "Phone", 699.99, 10));
        this.products.add(new Product(3, "Book", 29.99, 20));
        this.products.add(new Product(4, "Coffee", 12.99, 15));
        this.products.add(new Product(5, "Mouse", 25.99, 8));
    }

    public ArrayList<Product> getAllProducts() {
        return this.products;
    }

    public Product findProduct(int var1) {
        for(Product var3 : this.products) {
            if (var3.id == var1) {
                return var3;
            }
        }

        return null;
    }

    public ArrayList<Product> searchProducts(String var1) {
        ArrayList var2 = new ArrayList();

        for(Product var4 : this.products) {
            if (var4.name.toLowerCase().contains(var1.toLowerCase())) {
                var2.add(var4);
            }
        }

        return var2;
    }
}
