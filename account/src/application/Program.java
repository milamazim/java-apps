package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.InputMismatchException;

import entities.Account;
import exceptions.DomainException;

public class Program {
  public static void main(String[] args) {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    try {
      System.out.println("Enter account data");
      System.out.print("Number: ");
      int number = sc.nextInt();
      sc.nextLine();
      System.out.print("Holder: ");
      String holder = sc.nextLine();
      System.out.print("Initial balance: ");
      double initialBalance = sc.nextDouble();
      System.out.print("Withdraw limit: ");
      double withdrawLimit = sc.nextDouble();

      Account acc = new Account(number, holder, initialBalance, withdrawLimit);

      System.out.println();
      System.out.print("Enter amount for withdraw: ");
      double amount = sc.nextDouble();
      acc.withdraw(amount);
      System.out.print("New balance: ");
      System.out.printf("%.2f", acc.getBalance());
      
    } 
    catch (DomainException e) {
      System.out.println("Withdraw error: " + e.getMessage());
    } 

    catch (InputMismatchException e) {
      System.out.println("Invalid character");
    }

    finally {
      sc.close();
    }   
    
  }

}
