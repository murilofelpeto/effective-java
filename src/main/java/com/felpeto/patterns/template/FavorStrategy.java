package com.felpeto.patterns.template;

import static java.util.Objects.requireNonNull;

import java.util.function.Supplier;

//Utilizando o strategy com o supplier, não precisamos mais ficar criando implementações de classes
public class FavorStrategy {

  private final Supplier<String> supplier;

  private FavorStrategy(final Supplier<String> supplier) {
    this.supplier = supplier;
  }

  public static FavorStrategy of(final Supplier<String> supplier) {
    requireNonNull(supplier);
    return new FavorStrategy(supplier);
  }

  public void doSomething() {
    System.out.println("A");
    System.out.println("A");
    System.out.println("A");
    System.out.println("A");
    System.out.println("A");
    System.out.println(supplier.get());
    System.out.println("B");
    System.out.println("B");
    System.out.println("B");
    System.out.println("B");
    System.out.println("B");

  }

  public static void main(String[] args) {
    FavorStrategy.of(() -> "One").doSomething();
    System.out.println("---------------------------");
    FavorStrategy.of(() -> "Two").doSomething();
  }
}
