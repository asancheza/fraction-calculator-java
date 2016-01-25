/**
 * Fraction class
 * 
 * @author Alejandro Sanchez Acosta
 */

public class Fraction implements FractionInterface {
  private int numerator = 0;
  private int denominator = 1;

  public Fraction(Integer numerator, Integer denominator)
  {
    this.numerator = numerator;
    this.denominator = denominator;

    if (denominator.equals(0)) {
      throw new IllegalFractionException("Cannot have 0 as denominator");
    }
  }

  public String toString() {
    String fractionString = this.numerator + " / " + this.denominator;
    
    return fractionString;
  }

  public FractionInterface add(FractionInterface f2) {
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    Integer numerator3 = this.numerator * denominator2 + numerator2 * this.denominator;
    Integer denominator3 = this.denominator * denominator2;

    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();

    return result;
  }

  public FractionInterface subtract(FractionInterface f2) {
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    Integer numerator3 = this.numerator * denominator2 - numerator2 * denominator;
    Integer denominator3 = this.denominator * denominator2;

    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();

    return result;
  }

  public FractionInterface multiply(FractionInterface f2) {
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    Integer numerator3 = this.numerator * numerator2;
    Integer denominator3 = this.denominator * denominator2;
    
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    
    return result;
  }

  public FractionInterface divide(FractionInterface f2) {
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    Integer numerator3 = this.numerator * denominator2;
    Integer denominator3 = this.denominator * numerator2;
    
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    
    return result;
  }

  public void reduceToLowestTerms() {
    Integer gcd = this.greatestCommonDivisor(numerator, denominator);

    if (gcd < 0) 
      gcd = -gcd;

    this.numerator = this.numerator / gcd;
    this.denominator = this.denominator / gcd;
  }

  private Integer greatestCommonDivisor(Integer a, Integer b) {
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
  public Integer getNumerator() {
    return numerator;
  }

  /**
   *
   * Get denominator
   *
   * @return the denominator
   */
  public Integer getDenominator() {
    // Return the Data Field.
    return denominator;
  }

  /**
   * 
   * Set numerator
   *
   * @param numerator
   */
  public void setNumerator(Integer numerator) {
    this.numerator = numerator;
  }

  /**
   * Set denominator
   * 
   * @param denominator 
   * @exception IllegalFractionException if the denominator is zero
   */
  public void setDenominator(Integer denominator) throws IllegalFractionException {
    this.denominator = denominator;
    if (denominator == 0) {
      throw new IllegalFractionException("Cannot have a denominator that is zero!");
    }
  }

  /**
   * Compare
   * 
   * @param Object 
   * @exception ClassCastException
   */
  public int compareTo(Object object2) throws ClassCastException {
    Fraction fraction2 = (Fraction) object2;
    int numerator1 = numerator * fraction2.getDenominator();
    int numerator2 = fraction2.getNumerator() * denominator;
    int result = numerator1 - numerator2;
    return result;
  }
}