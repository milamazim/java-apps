package entities;

public class Individual extends TaxPayer {

  private Double healthExpeditures;

  public Individual(){
    super();    
  }

  public Individual(String name, Double anualIncome, Double healthExpeditures) {
    super(name, anualIncome);
    this.healthExpeditures = healthExpeditures;
  }

  public Double getHealthExpeditures() {
    return healthExpeditures;
  }

  public void setHealthExpeditures(Double healthExpeditures) {
    this.healthExpeditures = healthExpeditures;
  }

  @Override
  public final Double tax(){

    double taxes;

    if (getAnualIncome() < 20000.00) {
      taxes = getAnualIncome() * 0.15;
    }
    else {
      taxes = getAnualIncome() * 0.25;
    }

    if (healthExpeditures > 0) {
      return taxes - (healthExpeditures/2);
    }
    else {
      return taxes;
    }   

  }

}
