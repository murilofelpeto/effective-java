package com.felpeto.patterns.visitor.patternMatching;

import com.felpeto.patterns.visitor.deprecated.CreditCard;
import com.felpeto.patterns.visitor.deprecated.MasterCard;
import com.felpeto.patterns.visitor.deprecated.Visa;

public class PatternMatching {

  public int run(CreditCard card) {
    return switch (card) {
      case Visa visa -> 1;
      case MasterCard masterCard-> 2;
    };
  }

}

class OtherPatternMatching {
  public String run(CreditCard card) {
      return switch (card) {
        case Visa visa -> "Visa";
        case MasterCard masterCard-> "MasterCard";
      };
  }
}
