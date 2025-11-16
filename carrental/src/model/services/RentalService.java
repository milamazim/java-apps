package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

  private Double pricePerDay;
  private Double pricePerHour;

  private BrazilTaxServices taxService;

  public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxServices taxService) {
    this.pricePerDay = pricePerDay;
    this.pricePerHour = pricePerHour;
    this.taxService = taxService;
  }

  public void processInvoice(CarRental carRental) {
    long t1 = carRental.getStart().getTime();
    long t2 = carRental.getFinish().getTime();
    double hours = (double)(t2 - t1)/1000/60/60; // milisegundos / 1000, segundos / 60, minutos / 60 , resultado horas
    double basicPayment;

    if (hours <= 12.0) {
      basicPayment = Math.ceil(hours) * pricePerHour; // cobra por hora      
    }
    else {
      basicPayment = Math.ceil(hours / 24) * pricePerDay; // converte para diária      
    }

    double tax = taxService.tax(basicPayment);

    carRental.setInvoice(new Invoice(basicPayment, tax));

  }

}
