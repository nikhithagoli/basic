import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for item.
 */
class Item {
    /**
     * name.
     */
    private String pname;
    /**
     * quantity.
     */
    private int quantity;
    /**
     * price.
     */
    private double price;
    private boolean catalog = false;
    Item(final String n, final int q, final double p) {
        this.pname = n;
        this.quantity = q;
        this.price = p;
        this.catalog = true;
    }
    Item(final String n, final int q) {
        this.pname = n;
        this.quantity = q;
    }
    public String getpname() {
        return pname;
    }

    public int getquantity() {
        return quantity;
    }

    double getprice() {
        return price;
    }
    void setquantity(int quant) {
        this.quantity = quant;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (catalog) {
            return pname + " " + quantity + " " + price;
        }
        return pname + " " + quantity;
    }
}

class Shoppingcart {
    private ArrayList<Item> catalog;
    private ArrayList<Item> cart;
    double discount, tax;
    String[] coupons = {"IND10", "IND20", "IND30", "IND50"};
    boolean flag = true;
    double tot, pay;
    Shoppingcart() {
        catalog = new ArrayList<>();
        cart = new ArrayList<>();
        discount = 0;
        tax = 0;
        tot = 0;
        pay = 0;
    }
    void addToCatalog(Item item) {
        catalog.add(item);
    }
    void addToCart(Item item) {
        for ( Item each : catalog) {
            if (each.getpname().equals(item.getpname())) {
                for (Item f : cart) {
                    if (f.getpname().equals(item.getpname())) {
                        f.setquantity(f.getquantity() + item.getquantity());
                        return;
                    }
                }
                cart.add(item);
                return;
            }
        }
    }
    void removeFromCart(Item item) {
        for (Item e : cart) {
            if (e.getpname().equals(item.getpname())) {
                if (e.getquantity() == item.getquantity()) {
                    cart.remove(e);
                    return;
                } else {
                    e.setquantity(e.getquantity() - item.getquantity());
                    return;
                }
            }
        }

    }
    void showCart() {
        for (Item e : cart) {
            System.out.println(e);
        }
    }
    void showCatalog() {
        for (Item each : catalog) {
            System.out.println(each);
        }
    }
    double getprice(String name) {
        for (Item e : catalog) {
            if (e.getpname().equals(name)) {
                return e.getprice();
            }
        }
        return 0;
    }
    double getTotalAmount() {
        tot = 0;
        for (Item e : cart) {
            tot += e.getquantity() * this.getprice(e.getpname());
        }
        return (tot);
    }
    double getPayableAmount() {
        double amount = getTotalAmount();
        double total = (amount - ((amount * discount) / 100));
        tax = (total  * 15) / 100;
        pay = total + tax;
        return (pay);
    }
    void applyCoupon(String coupon) {
        if (flag) {
            for (String i : coupons) {
                if (i.equals(coupon)) {
                    discount = Double.parseDouble(coupon.substring(3));
                    flag = false;
                    return;
                }
            }
        }
        System.out.println("Invalid coupon");
    }
    void printInvoice() {
        System.out.println("Name   " + "quantity   " + "Price");
        for (Item each : cart) {
            System.out.println(each + " " + Double.toString(this.getprice(each.getpname())));
        }
        System.out.println("Total:" + Double.toString(tot));
        System.out.println("Disc%:" + Double.toString((tot * discount) / 100));
        System.out.println("Tax:" + Double.toString(tax));
        System.out.println("Payable amount: " + Double.toString(pay));

    }

}
final class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Shoppingcart s = new Shoppingcart();
        int n = sc.nextInt();
        for (int i = 0; i < n + 1; i++) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] item = tokens[1].split(",");
                s.addToCatalog(new Item(item[0], Integer.parseInt(item[1]), Double.parseDouble(item[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                item = tokens[1].split(",");
                s.addToCart(new Item(item[0], Integer.parseInt(item[1])));
                break;
            case "show":
                s.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + s.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + s.getPayableAmount());
                break;
            case "remove":
                item = tokens[1].split(",");
                s.removeFromCart(new Item(item[0], Integer.parseInt(item[1])));
                break;
            case "coupon":
                s.applyCoupon(tokens[1]);
                break;
            case "print":
                s.printInvoice();
                break;
            }
        }
    }
}