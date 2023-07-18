package com.felpeto.patterns.visitor.deprecated;

public final class Visa extends CreditCard {

  @Override
  public <T> T somethingOne(final CardVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
