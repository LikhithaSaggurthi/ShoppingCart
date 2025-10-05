public class Product {
    public int id;
    public String name;
    public double price;
    public int stock;

    public Product(int var1, String var2, double var3, int var5) {
        this.id = var1;
        this.name = var2;
        this.price = var3;
        this.stock = var5;
    }

    public boolean isAvailable() {
        return this.stock > 0;
    }
}