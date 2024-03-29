/*
Descrição
O padrão de projeto Adapter é um padrão de projeto estrutural que permite que objetos com interfaces incompatíveis trabalhem juntos. Ele atua como um intermediário, adaptando a interface de uma classe para outra interface esperada pelo cliente.

Neste desafio, você deverá implementar um conversor de moedas que permitirá que valores monetários sejam convertidos de dólares americanos (USD) para euros (EUR). Embora exista uma taxa de conversão direta de 1 USD = 0.85 EUR, o nosso sistema inicialmente só suportava a conversão de USD para libras esterlinas (GBP). Utilizando o padrão Adapter, você deve adaptar esse sistema antigo para fornecer a nova funcionalidade de conversão direta para EUR, usando a conversão intermediária para GBP.

Entrada
Um valor em dólares americanos USD (Double).

Saída
O valor convertido para euros EUR (Double) usando o adaptador.

Taxa de conversão direta (para referência):
1 USD = 0.85 EUR

Taxas de conversão para a adaptação:
1 USD para GBP = 0.80
1 GBP para EUR = 1.0625

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.
 */

import java.util.Scanner;

public class ConverterMoedasAdapter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double input = Double.parseDouble(scanner.nextLine());

    OldCurrencyConverter oldConverter = new OldCurrencyConverter();
    CurrencyAdapter adapter = new CurrencyAdapter(oldConverter);

    // TODO: Chamar o método para converter USD para a nova moeda desejada (por exemplo, JPY)
    // Convertendo USD para EUR
    double convertedAmount = adapter.convertUSDtoEUR(input);

    // TODO: Imprimir o resultado da conversão

    System.out.println("USD: " + input);
    System.out.println("EUR: " + convertedAmount);
  }
}

class OldCurrencyConverter {
  public double convertUSDtoGBP(double amount) {
    return amount * 0.80; // 80% do valor em USD
  }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
  private final OldCurrencyConverter oldConverter;

  public CurrencyAdapter(OldCurrencyConverter oldConverter) {
    this.oldConverter = oldConverter;
  }

  public double convertUSDtoEUR(double amount) {
    double amountInGBP = oldConverter.convertUSDtoGBP(amount);
    return amountInGBP * 1.0625; // Conversão de GBP para EUR
  }

}
