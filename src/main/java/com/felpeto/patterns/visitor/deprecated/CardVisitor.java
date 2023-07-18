package com.felpeto.patterns.visitor.deprecated;

public interface CardVisitor<T> {

  T visit(Visa visa);

  T visit(MasterCard masterCard);
}
