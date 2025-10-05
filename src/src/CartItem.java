public class CartItem {
    public Product product;
    public int quantity;

    public CartItem(Product var1, int var2) {
        this.product = var1;
        this.quantity = var2;
    }

    public double getTotalPrice() {
        return this.product.price * (double)this.quantity;
    }
}
