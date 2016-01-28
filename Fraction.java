/**
 * Fraction class
 * 
 * @author Alejandro Sanchez Acosta
 */

public class Fraction implements FractionInterface {
  private int numerator = 0;
  private int denominator = 1;

  /**
   *
   * Fraction constructor
   *
   */
  public Fraction(int numerator, int denominator)
  {
    this.numerator = numerator;
    this.denominator = denominator;

    if (this.denominator == 0) {
      throw new IllegalFractionException("Cannot have 0 as denominator");
    }
  }

  /**
   *
   * Convert fraction to string
   *
   * @return the fraction string
   */
  public String toString() {
    String fractionString = this.getNumerator() + " / " + this.getDenominator();
    
    return fractionString;
  }

  /**
   *
   * Add fractions
   *
   * @return the fraction added
   */
  public FractionInterface add(FractionInterface f2) {
    int numerator = this.getNumerator() * f2.getDenominator() + f2.getNumerator() * this.getDenominator();
    int denominator = this.denominator * f2.getDenominator();

    FractionInterface result = new Fraction(numerator, denominator);
    result.reduceToLowestTerms();

    return result;
  }

  /**
   *
   * Subtract fractions
   *
   * @return the fraction subtracted
   */
  public FractionInterface subtract(FractionInterface f2) {
    int numerator = this.getNumerator() * f2.getDenominator() - f2.getNumerator() * this.getDenominator();
    int denominator = this.getDenominator() * f2.getDenominator();;

    FractionInterface result = new Fraction(numerator, denominator);
    result.reduceToLowestTerms();

    return result;
  }

  /**
   *
   * Multiply fractions
   *
   * @return the fraction multiplied
   */
  public FractionInterface multiply(FractionInterface f2) {
    int numerator = this.getNumerator() * f2.getNumerator();
    int denominator = this.getDenominator() * f2.getDenominator();
    
    FractionInterface result = new Fraction(numerator, denominator);
    result.reduceToLowestTerms();
    
    return result;
  }

  /**
   *
   * Divide fractions
   *
   * @return the fraction divided
   */
  public FractionInterface divide(FractionInterface f2) {
    int numerator = this.getNumerator() * f2.getNumerator();
    int denominator = this.getDenominator() * f2.getDenominator();
    
    FractionInterface result = new Fraction(numerator, denominator);
    result.reduceToLowestTerms();
    
    return result;
  }

  /**
   *
   * Reduce fraction
   *
   * @return the fraction reduced
   */
  public void reduceToLowestTerms() {
    int gcd = this.greatestCommonDivisor(this.getNumerator(), this.getDenominator());

    if (gcd < 0) 
      gcd = -gcd;

    this.numerator = this.numerator / gcd;
    this.denominator = this.denominator / gcd;
  }

  /**
   *
   * Get greatest common divisor
   *
   * @return the gcd
   */
  private int greatestCommonDivisor(int a, int b) {
    if ((a % b) == 0) {
      return b;
    } else {
      return greatestCommonDivisor(b, a % b);
    }
  }

  /**
   *
   * Get numerator
   *
   * @return the denominator
   */
  public int getNumerator() {
    return numerator;
  }

  /**
   *
   * Get denominator
   *
   * @return the denominator
   */
  public int getDenominator() {
    return denominator;
  }

  /**
   * 
   * Set numerator
   *
   * @param numerator
   */
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  /**
   * Set denominator
   * 
   * @param denominator 
   * @exception IllegalFractionException if the denominator is zero
   */
  public void setDenominator(int denominator) throws IllegalFractionException {
    this.denominator = denominator;

    if (denominator == 0) {
      throw new IllegalFractionException("Cannot have a denominator that is zero!");
    }
  }

  /**
   * Compare fractions
   * 
   * @param Object 
   * @exception ClassCastException
   */
  public int compareTo(Object object2) throws ClassCastException {
    Fraction fraction2 = (Fraction) object2;
    int numerator1 = this.getNumerator() * fraction2.getDenominator();
    int numerator2 = fraction2.getNumerator() * this.getDenominator();
    int result = numerator1 - numerator2;

    return result;
  }

  /**
   * Reciprocal method returns the recriprocal fraction
   * 
   * @return new Fraction
   */
  public Fraction reciprocal() {
    return new Fraction(this.getDenominator(), this.getNumerator());
  }
}