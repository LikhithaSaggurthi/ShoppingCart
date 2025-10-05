import java.util.ArrayList;

public class OrderManager {
    public ArrayList<Order> orders = new ArrayList();
    public int nextOrderId = 1001;

    public Order createOrder(ShoppingCart var1) {
        if (var1.isEmpty()) {
            System.out.println("Cannot create order - cart is empty!");
            return null;
        } else {
            Order var2 = new Order(this.nextOrderId, var1.items, var1.getTotalAmount());
            this.orders.add(var2);
            ++this.nextOrderId;
            var1.clear();
            return var2;
        }
    }

    public void showOrderHistory() {
        if (this.orders.isEmpty()) {
            System.out.println("No orders found!");
        } else {
            System.out.println("\n=== Order History ===");

            for(Order var2 : this.orders) {
                System.out.printf("Order #%d - Total: $%.2f - Status: %s%n", var2.orderId, var2.totalAmount, var2.status);
            }

        }
    }
}
