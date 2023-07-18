package com.felpeto.patterns.strategy;

import java.util.function.IntBinaryOperator;

public enum Operation {

  ADD(AddOperation::compute),
  SUBTRACT((x, y) -> x - y),
  MULTIPLY((x, y) -> x * y),
  DIVIDE((x, y) -> x / y);

  private final IntBinaryOperator operator;

  Operation(final IntBinaryOperator operator) {
    this.operator = operator;
  }

  public int compute(int x, int y) {
    return operator.applyAsInt(x, y);
  }
}
