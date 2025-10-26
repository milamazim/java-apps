package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {
    public static void main(String[] args) {        
        
        List<Product> products = new ArrayList<>();

        File directory = new File("out");
          if (!directory.exists()) {
            directory.mkdir();
          }

        String originPath = "base.csv";
        String destinyPath = "out/summary.csv";                

        try (BufferedReader br = new BufferedReader(new FileReader(originPath))) {
            
            String line = br.readLine();
            
            while (line != null) {
                String[] columns = line.split(",");
                
                String name = columns[0];
                Double price = Double.parseDouble(columns[1]);
                Integer quantity = Integer.parseInt(columns[2]);
                
                Product product = new Product(name, price, quantity);
                products.add(product);
                
                line = br.readLine();
            }

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destinyPath, true))) {

          for (Product p : products) {
            bw.write(p.getName() + "," + p.totalPrice());
            bw.newLine();
          }

        }
                  
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
