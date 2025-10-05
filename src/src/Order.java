import java.util.ArrayList;

public class Order {
    public int orderId;
    public ArrayList<CartItem> items;
    public double totalAmount;
    public String status;

    public Order(int var1, ArrayList<CartItem> var2, double var3) {
        this.orderId = var1;
        this.items = new ArrayList(var2);
        this.totalAmount = var3;
        this.status = "Confirmed";
    }
}