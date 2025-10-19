package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
  public static void main(String[] args) {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<TaxPayer> list = new ArrayList<>();

    System.out.print("Enter the number of tax payers: ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= n; i++) {
      System.out.println("Tax payer #" + i + " data: ");
      System.out.print("Individual or company (i/c)? ");
      char taxpayer = sc.next().charAt(0);
      sc.nextLine();
      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Anual income: ");
      double anualIncome = sc.nextDouble();
      sc.nextLine();

      if (taxpayer == 'i') {
        System.out.print("Health expenditures: ");
        double healthExpeditures = sc.nextDouble();
        sc.nextLine();
        list.add(new Individual(name, anualIncome, healthExpeditures));
      }
      else if (taxpayer == 'c') {
        System.out.print("Number of employees: ");
        int numberEmployees = sc.nextInt();
        sc.nextLine();
        list.add(new Company(name, anualIncome, numberEmployees));
      }     


    }

    System.out.println();
    System.out.println("TAXES PAID: ");

    double total = 0.0;

    for (TaxPayer t : list) {        
      System.out.println(t.getName() + ": $ " + String.format("%.2f", t.tax()));
      total += t.tax();
    }

    System.out.println();
    System.out.print("TOTAL TAXES: $ " + String.format("%.2f", total));

    sc.close();

  }

}
