package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
  public static void main(String[] args) throws ParseException {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<Product> list = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Enter the number of products: ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= n; i++) {
      System.out.println("Product #" + i + " data:");
      System.out.print("Common, used or imported (c/u/i)? ");
      char productType = sc.next().charAt(0);
      sc.nextLine();
      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Price: ");
      double price = sc.nextDouble();
      sc.nextLine(); 

      if (productType == 'i') {
        System.out.print("Customs fee: ");
        double fee = sc.nextDouble();
        list.add(new ImportedProduct(name, price, fee));
      }
      else if (productType == 'u') {
        System.out.print("Manufacture date (DD/MM/YYYY): ");
        String date = sc.nextLine();        
        list.add(new UsedProduct(name, price, sdf.parse(date)));
      }
      else {
        list.add(new Product(name, price));
      }      
      
    }

    System.out.println();
    System.out.println("PRICE TAGS: ");
      for (Product prod : list) {
        System.out.println(prod.priceTag());
      }

    sc.close();

  }

}
