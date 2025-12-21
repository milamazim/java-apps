package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {
  public static void main(String[] args) {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Entre o caminho do arquivo: ");
    String path = sc.nextLine();    

    try (BufferedReader br = new BufferedReader(new FileReader(path))) {

      List<Sale> list = new ArrayList<>();

      String line = br.readLine();

      while(line != null) {
        String[] fields = line.split(",");
        Integer month = Integer.parseInt(fields[0]);
        Integer year = Integer.parseInt(fields[1]);
        String seller = fields[2];
        Integer items = Integer.parseInt(fields[3]);
        Double total = Double.parseDouble(fields[4]);

        list.add(new Sale(month, year, seller, items, total));
        line = br.readLine();        
      }

      System.out.println();
      System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");       

      List<Sale> newList = list.stream()
        .filter(s -> s.getYear() == 2016)
        .sorted((t1,t2) -> t2.averagePrice().compareTo(t1.averagePrice()))         
        .limit(5)                
        .collect(Collectors.toList());      
      
      newList.forEach(System.out::println);

      List<Sale> logan = list.stream()        
        .filter(s -> s.getSeller().equals("Logan") && (s.getMonth() == 1 || s.getMonth() == 7))        
        .collect(Collectors.toList());     

      Double totalLogan = logan.stream()        
        .map(t -> t.getTotal())
        .reduce(0.0, (x,y) -> x + y);
      
      System.out.println();
      System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " + totalLogan);   

    } catch (IOException e) {
      System.out.println("Erro: " + e.getMessage());
    }

    sc.close();

  }

}
