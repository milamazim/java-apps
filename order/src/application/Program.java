package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
  public static void main(String[] args) throws ParseException {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Enter client data: ");
    System.out.print("Name: ");
    String clientName = sc.nextLine();
    System.out.print("Email: ");
    String clientEmail = sc.nextLine();
    System.out.print("Birth date (DD/MM/YYYY): ");
    String clientBirthDate = sc.nextLine();

    Client client = new Client(clientName, clientEmail, sdf.parse(clientBirthDate));

    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    String orderStatus = sc.nextLine();
    
    Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), client);

    System.out.print("How many items to this order? ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= n; i++) {
      System.out.println("Enter #" + i + " item data: ");
      System.out.print("Product name: ");
      String productName = sc.nextLine();
      System.out.print("Product price: ");
      double productPrice = sc.nextDouble();
      System.out.print("Quantity: ");
      int productQty = sc.nextInt();
      sc.nextLine();

      OrderItem item = new OrderItem(productQty, productPrice, new Product(productName, productPrice));
      order.addItem(item);
    }

    orderSummary(order);

    sc.close();

  }

  public static void orderSummary(Order order){
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println();
    System.out.println("ORDER SUMMARY: ");
    System.out.println("Order moment: " + sdf1.format(order.getMoment()));
    System.out.println("Order status: " + order.getStatus());
    System.out.println("Client: " + order.getClient().getName() + " (" + sdf2.format(order.getClient().getBirthDate()) + ")" 
      + " - " + order.getClient().getEmail());
    System.out.println("Order items: ");

    for (OrderItem i : order.getItems()) {
      System.out.printf("%s, $%.2f, Quantity: %d, Subtotal: $%.2f %n", 
        i.getProduct().getName(), i.getPrice(), i.getQuantity(), i.subTotal());      
    }

    System.out.printf("Total price: $%.2f", order.total());

  }

}
