import java.util.*;

class Product implements Comparable<Product> {

    private int productid;
    private String productName;
    private double productPrice;
    private int quantity;

    void SetProductId(int productid) {
        this.productid = productid;
    }

    int getProductId() {
        return productid;
    }

    void setProductName(String productName) {
        this.productName = productName;
    }

    String getProductName() {
        return productName;
    }

    void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    double getProductPrice() {
        return productPrice;
    }

    void Setquantity(int quantity) {
        this.quantity = quantity;
    }

    int getquantity() { // Corrected: removed int quantity parameter
        return quantity;
    }

    Product(int productid, String productName, double productPrice, int quantity) {
        this.productid = productid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String toString() {
        return " Product id : " + productid + "Productname : " + productName + " Product price " + productPrice + "Quantity " + quantity;
    }

    public int compareTo(Product p) {
        if (getProductPrice() < p.getProductPrice()) {
            return -1;
        } else if (getProductPrice() > p.getProductPrice()) {
            return +1;
        } else {
            return 0;
        }
    }
}

class ShortQantity implements Comparator<Product> { // Corrected: Implements Comparator<Product>

    public int compare(Product p1, Product p2) { // Corrected: Correct compare method signature
        return Double.compare(-p1.getquantity(), p2.getquantity()); // Corrected: Direct int comparison
    }
}
class ShortName implements Comparator < Product> 
{
	
	public int compare ( Product p1, Product p2 )
	{
		return p1.getProductName ().compareTo(p2.getProductName ());
	}
}
class Main {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<Product>();
        Scanner scn = new Scanner(System.in);
        System.out.println(" Enter number of product to be entered ");
        int size = scn.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println(" Enter the  id of the product ");
            int id = scn.nextInt();
            System.out.println(" Enter product name ");
            scn.nextLine();
            String name = scn.nextLine();
            System.out.println(" Enter product price ");
            double price = scn.nextDouble();
            System.out.println(" Enter quantity ");
            int qty = scn.nextInt();
            Product obj = new Product(id, name, price, qty);
            list.add(obj);
        }
        Collections.sort(list);
        System.out.println(" Enter product price in ascending order ");
        for (Product i : list) {
            System.out.println(i);
        }
        Collections.sort(list, new ShortQantity()); // Corrected: Pass list and comparator
        System.out.println(" Display quantity in descendingorder "); //corrected output message.
        for (Product i : list) {
            System.out.println(i);
        }
		
		Collections.sort(list, new ShortName()); // Corrected: Pass list and comparator
        System.out.println(" Display Name  in aescendingorder "); //corrected output message.
        for (Product i : list) {
            System.out.println(i);
        }
    }
}
