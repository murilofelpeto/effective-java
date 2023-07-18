package com.felpeto.patterns.template;

//TEMPLATE METHOD FOI DEPRECIADO POR CONTA DO LAMBDA
public abstract class DeprecatedTemplateMethod {

  public void doSomething() {
    System.out.println("A");
    System.out.println("A");
    System.out.println("A");
    System.out.println("A");
    System.out.println("A");
    System.out.println(getValue());
    System.out.println("B");
    System.out.println("B");
    System.out.println("B");
    System.out.println("B");
    System.out.println("B");

  }

  public abstract String getValue();

}

class OneImplementation extends DeprecatedTemplateMethod {
  @Override
  public String getValue() {
    return "One";
  }
}

class TwoImplementation extends DeprecatedTemplateMethod {
  @Override
  public String getValue() {
    return "Two";
  }
}
