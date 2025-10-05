import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<CartItem> items = new ArrayList();

    public void addProduct(Product var1, int var2) {
        for(CartItem var4 : this.items) {
            if (var4.product.id == var1.id) {
                var4.quantity += var2;
                return;
            }
        }

        this.items.add(new CartItem(var1, var2));
    }

    public void removeProduct(int var1) {
        this.items.removeIf((var1x) -> var1x.product.id == var1);
    }

    public double getTotalAmount() {
        double var1 = (double)0.0F;

        for(CartItem var4 : this.items) {
            var1 += var4.getTotalPrice();
        }

        return var1;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public CartItem findItem(int var1) {
        for(CartItem var3 : this.items) {
            if (var3.product.id == var1) {
                return var3;
            }
        }
        return null;
    }

    public void clear() {
        this.items.clear();
    }
}
