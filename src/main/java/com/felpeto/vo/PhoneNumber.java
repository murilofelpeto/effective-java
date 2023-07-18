package com.felpeto.vo;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Comparator;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

//Foque em objetos imutáveis, para diminuir a quantidade de bugs
//A interface de formmatable auxilia na internacionalização, exibição para o usuário com algo mais formatado e etc
//Se a classe permite fornecer dados de forma ordenada, implementamos a classe comparable
//Comparable é thread safe, por isso podemos extratir para uma constante
public class PhoneNumber implements Formattable, Comparable<PhoneNumber> {

  private static final Comparator<PhoneNumber> PHONE_COMPARATOR =
      Comparator
          .comparingInt((PhoneNumber p) -> p.areaCode)
          .thenComparing(p -> p.number);
  private final int areaCode;
  private final int number;


  private PhoneNumber(final int areaCode, final int number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public int getAreaCode() {
    return areaCode;
  }

  public int getNumber() {
    return number;
  }

  /*
      Vantagem -> Facilita a implementação de um flyweight pattern
      Posso retornar qualquer instância de PhoneNumber, por exemplo um LandLinePhoneNumber
     */
  public static PhoneNumber of(final int areaCode, final int number) {
    //regra de validação
    checkArgument(areaCode > 0, "areaCode must be greater than 0");
    checkArgument(number > 0, "number must be greater than 0");

    if (areaCode < 500) {
        // return outra instância
    }
    return new PhoneNumber(areaCode, number);
  }

  @Override
  public int compareTo(final PhoneNumber o) {
    return PHONE_COMPARATOR.compare(this, o);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final PhoneNumber that = (PhoneNumber) o;
    return areaCode == that.areaCode && number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(areaCode, number);
  }

  @Override
  public String toString() {
    return "PhoneNumber{" +
        "areaCode=" + areaCode +
        ", number=" + number +
        '}';
  }

  @Override
  public void formatTo(
      final Formatter formatter,
      final int flags,
      final int width,
      final int precision) {
    formatter.format("(%d) %d", areaCode, number, number);
  }

  public static void main(String[] args) {
    System.out.println(PhoneNumber.of(11, 456));
    System.out.printf("%s", PhoneNumber.of(15, 123));
  }
}

