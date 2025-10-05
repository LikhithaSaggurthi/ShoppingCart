import java.util.Scanner;

public class UserInterface {
    public Scanner scanner;
    public ProductManager productManager;
    public CartManager cartManager;
    public OrderManager orderManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.productManager = new ProductManager();
        this.cartManager = new CartManager(this.productManager);
        this.orderManager = new OrderManager();
    }

    public void start() {
        System.out.println("=== Welcome to Shopping Cart ===");

        while(true) {
            this.showMenu();
            int var1 = this.scanner.nextInt();
            switch (var1) {
                case 1:
                    this.showProducts();
                    break;
                case 2:
                    this.searchProducts();
                    break;
                case 3:
                    this.addToCart();
                    break;
                case 4:
                    this.cartManager.showCart();
                    break;
                case 5:
                    this.updateCart();
                    break;
                case 6:
                    this.removeFromCart();
                    break;
                case 7:
                    this.checkout();
                    break;
                case 8:
                    this.orderManager.showOrderHistory();
                    break;
                case 9:
                    System.out.println("Thank you for shopping!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. View Products");
        System.out.println("2. Search Products");
        System.out.println("3. Add to Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Update Cart");
        System.out.println("6. Remove from Cart");
        System.out.println("7. Checkout");
        System.out.println("8. Order History");
        System.out.println("9. Exit");
        System.out.print("Enter choice: ");
    }

    private void showProducts() {
        System.out.println("\n=== Products ===");

        for(Product var2 : this.productManager.getAllProducts()) {
            System.out.printf("ID: %d | %s | $%.2f | Stock: %d%n", var2.id, var2.name, var2.price, var2.stock);
        }

    }

    private void searchProducts() {
        System.out.print("Enter product name: ");
        this.scanner.nextLine();
        String var1 = this.scanner.nextLine();
        System.out.println("\n=== Search Results ===");

        for(Product var3 : this.productManager.searchProducts(var1)) {
            System.out.printf("ID: %d | %s | $%.2f | Stock: %d%n", var3.id, var3.name, var3.price, var3.stock);
        }

    }

    private void addToCart() {
        System.out.print("Enter product ID: ");
        int var1 = this.scanner.nextInt();
        System.out.print("Enter quantity: ");
        int var2 = this.scanner.nextInt();
        if (this.cartManager.addToCart(var1, var2)) {
            System.out.println("Added to cart!");
        }

    }

    private void updateCart() {
        this.cartManager.showCart();
        if (!this.cartManager.cart.isEmpty()) {
            System.out.print("Enter product ID to update: ");
            int var1 = this.scanner.nextInt();
            System.out.print("Enter new quantity: ");
            int var2 = this.scanner.nextInt();
            if (this.cartManager.updateCart(var1, var2)) {
                System.out.println("Cart updated!");
            }
        }
    }

    private void removeFromCart() {
        System.out.print("Enter product ID to remove: ");
        int var1 = this.scanner.nextInt();
        this.cartManager.removeFromCart(var1);
        System.out.println("Removed from cart!");
    }

    private void checkout() {
        this.cartManager.showCart();
        if (!this.cartManager.cart.isEmpty()) {
            System.out.print("Confirm order? (y/n): ");
            this.scanner.nextLine();
            String var1 = this.scanner.nextLine();
            if (var1.toLowerCase().startsWith("y")) {
                Order var2 = this.orderManager.createOrder(this.cartManager.cart);
                if (var2 != null) {
                    System.out.printf("Order placed! Order ID: %d%n", var2.orderId);
                }
            } else {
                System.out.println("Order cancelled!");
            }

        }
    }
}
