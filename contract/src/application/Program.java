package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {
  public static void main(String[] args) throws ParseException {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Entre os dados do contrato: ");    
    System.out.print("Numero: ");
    int contractNumber = sc.nextInt();
    sc.nextLine();
    System.out.print("Data (dd/MM/yyyy): ");
    Date data = sdf.parse(sc.next());
    System.out.print("Valor do contrato: ");
    double contractValue = sc.nextDouble();

    Contract contract = new Contract(contractNumber, data, contractValue);    

    System.out.print("Entre com o numero de parcelas: ");
    int N = sc.nextInt();

    ContractService cs = new ContractService(new PaypalService()); //injecao de dependencia usando construtor
    cs.processContract(contract, N); //cria as parcelas com as taxas baseado no contrato

    System.out.println("Parcelas: ");  
    for (Installment it : contract.getInstallments()) {
      System.out.println(it);      
    }
    
    sc.close();
    
  }

}
