package com.felpeto.patterns.strategy;

public enum DeprecatedOperation {
  ADD {
    @Override
    public int compute(int x, int y) {
      return x + y;
    }
  },
  SUBTRACT {
    @Override
    public int compute(int x, int y) {
      return x - y;
    }
  },
  MULTIPLY {
    @Override
    public int compute(int x, int y) {
      return x * y;
    }
  },
  DIVIDE {
    @Override
    public int compute(int x, int y) {
      return x / y;
    }
  };

  public abstract int compute(int x, int y);
}
