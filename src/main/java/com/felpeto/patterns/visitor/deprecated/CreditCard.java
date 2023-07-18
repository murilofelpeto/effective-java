package com.felpeto.patterns.visitor.deprecated;

public sealed abstract class CreditCard permits MasterCard, Visa {
 public abstract <T> T somethingOne(CardVisitor<T> visitor);

  public static void main(String[] args) {
    final CardVisitor<Integer> visitor = new CardVisitor<>() {
      @Override
      public Integer visit(Visa visa) {
        return 1;
      }

      @Override
      public Integer visit(final MasterCard masterCard) {
        return 2;
      }
    };

    System.out.println(visitor.visit(new MasterCard()));
  }
}

