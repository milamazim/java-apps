package entities.enums;

public enum OrderStatus {

  PENDING_PAYMENT(0),
  PROCESSING(1),
  SHIPPED(2),
  DELIVERED(3);

  private int valor;

  OrderStatus(int valor){
    this.valor = valor;    
  }

  public int getValor(){
    return valor;
  }

}
