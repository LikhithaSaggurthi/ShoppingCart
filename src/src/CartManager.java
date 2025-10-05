
public class CartManager {
    public ShoppingCart cart = new ShoppingCart();
    public ProductManager productManager;

    public CartManager(ProductManager var1) {
        this.productManager = var1;
    }

    public boolean addToCart(int var1, int var2) {
        Product var3 = this.productManager.findProduct(var1);
        if (var3 == null) {
            System.out.println("Product not found!");
            return false;
        } else if (var3.stock < var2) {
            System.out.println("Not enough stock!");
            return false;
        } else {
            this.cart.addProduct(var3, var2);
            var3.stock -= var2;
            return true;
        }
    }

    public void removeFromCart(int var1) {
        this.cart.removeProduct(var1);
    }

    public boolean updateCart(int var1, int var2) {
        CartItem var3 = this.cart.findItem(var1);
        if (var3 == null) {
            System.out.println("Product not in cart!");
            return false;
        } else {
            Product var4 = var3.product;
            int var5 = var2 - var3.quantity;
            if (var5 > 0 && var4.stock < var5) {
                System.out.println("Not enough stock!");
                return false;
            } else {
                var4.stock += var3.quantity;
                var3.quantity = var2;
                var4.stock -= var2;
                return true;
            }
        }
    }

    public void showCart() {
        if (this.cart.isEmpty()) {
            System.out.println("Cart is empty!");
        } else {
            System.out.println("\n=== Your Cart ===");

            for(CartItem var2 : this.cart.items) {
                System.out.printf("ID: %d | %s - Qty: %d - Price: $%.2f%n", var2.product.id, var2.product.name, var2.quantity, var2.getTotalPrice());
            }

            System.out.printf("Total: $%.2f%n", this.cart.getTotalAmount());
        }
    }
}
