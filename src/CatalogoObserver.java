/*
Descrição
Você deve aprimorar o sistema de monitoramento de produtos, adicionando a capacidade de exibir uma mensagem específica para cada usuário quando um novo produto é adicionado ao catálogo. Além disso, implemente a funcionalidade de permitir que os usuários cancelem sua assinatura para deixar de receber notificações sobre novos produtos.

Entrada
O programa deve solicitar ao usuário que insira o nome do usuário para realizar a ação desejada.
Se o usuário deseja cancelar a assinatura, ele deve digitar "cancelar". Se desejar receber notificações, deve digitar qualquer outro valor.
Se o usuário optar por adicionar um novo produto, será solicitado o nome do produto a ser adicionado.
Saída
Após cada ação, o programa deve exibir mensagens informativas para indicar se a assinatura foi cancelada com sucesso, se o usuário ainda está assinando notificações ou se o produto foi adicionado ao catálogo.


 */

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface Observer
interface Observer {
  void update(String productName);
}

// Classe concreta Observer
class UserObserver implements Observer {
  private String name;

  public UserObserver(String name) {
    this.name = name;
  }

  @Override
  public void update(String productName) {
    System.out.println("Notificacao recebida: Novo produto adicionado - " + productName);
  }
}

// Interface Observable
interface CatalogObservable {
  void addObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers(String productName);
}

// Classe concreta Observable
class Catalog implements CatalogObservable {
  private List<Observer> observers = new ArrayList<>();

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String productName) {
    for (Observer observer : observers) {
      observer.update(productName);
    }
  }

  public void addProduct(String name, String description, double price) {
    notifyObservers(name);
  }
}

public class CatalogoObserver {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Criando catálogo e usuário
    Catalog catalog = new Catalog();
    UserObserver user = new UserObserver("Usuário 1");

    // Adicionando novo produto
    String name = scanner.nextLine();
    String description = scanner.nextLine();
    double price = scanner.nextDouble();

    scanner.nextLine(); // Consumir a quebra de linha após nextDouble
    String subscribeChoice = scanner.nextLine();

    // Verifique qual foi a escolha de notificação (S ou N) do usuário
    if (!"N".equalsIgnoreCase(subscribeChoice)) {
      catalog.addObserver(user);
    }

    if("N".equalsIgnoreCase(subscribeChoice)){
      catalog.removeObserver(user);

    // Adicionando produto ao catálogo
    catalog.addProduct(name, description, price);

    // Se a escolha for N, não há necessidade de remover o usuário, pois ele não foi adicionado
  }
}
