# Account

Programa para cadastro de conta corrente que permite o saque apenas quando o valor é inferior ao saldo e ao limite de saque. Quando não atende a estas condições, o programa retorna um erro com exceções tratadas.
Exercício elaborado no curso de Java do prof. Nelio Alves.

## Tela do Sistema

```text
Enter account data
Number: 8021
Holder: Bob Brown
Initial balance: 500.00
Withdraw limit: 300.00

Enter amount for withdraw: 800.00
Withdraw error: The amount exceeds withdraw limit
```

```text
Enter account data
Number: 8021
Holder: Bob Brown 
Initial balance: 200.00
Withdraw limit: 300.00

Enter amount for withdraw: 250.00
Withdraw error: Not enough balance
```