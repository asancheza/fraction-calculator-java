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
    Integer numerator3 = numerator * denominator2 - numerator2 * denominator;
    Integer denominator3 = denominator * denominator2;

    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();

    return result;
  }

  public FractionInterface multiply(FractionInterface f2) {
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    Integer numerator3 = numerator * numerator2;
    Integer denominator3 = denominator * denominator2;
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    return result;
  }

  public FractionInterface divide(FractionInterface f2) {
    Integer numerator2 = f2.getNumerator();
    Integer denominator2 = f2.getDenominator();
    Integer numerator3 = numerator * denominator2;
    Integer denominator3 = denominator * numerator2;
    FractionInterface result = new Fraction(numerator3, denominator3);
    result.reduceToLowestTerms();
    return result;
  }

  public void reduceToLowestTerms() {
    Integer gcd = this.greatestCommonDivisor(numerator, denominator);

    if (gcd < 0) 
      gcd = -gcd;

    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }

  private Integer greatestCommonDivisor(Integer a, Integer b) {
    if ((a % b) == 0) {
      return b;
    } else {
      return greatestCommonDivisor(b, a % b);
    }
  }

  public Integer getNumerator() {
    return numerator;
  }

  /**
   * @return the denominator
   */
  public Integer getDenominator() {
    // Return the Data Field.
    return denominator;
  }

  /**
   * @param numeratorParameter is the first name.
   */
  public void setNumerator(Integer numeratorParameter) {
    // SEt the Data Field.
    numerator = numeratorParameter;
  }

  /**
   * This Is A "Mutator" Method - Used To Set A Data Field.
   * 
   * @param lastNameParameter is the last name.
   * @exception IllegalFractionException if the denominator is zero
   */
  public void setDenominator(Integer denominatorParameter) throws IllegalFractionException {
    denominator = denominatorParameter;
    if (denominator == 0) {
      throw new IllegalFractionException("Cannot have a denominator that is zero!");
    }
  }

  public int compareTo(Object object2) throws ClassCastException {
    Fraction fraction2 = (Fraction) object2;
    int numerator1 = numerator * fraction2.getDenominator();
    int numerator2 = fraction2.getNumerator() * denominator;
    int result = numerator1 - numerator2;
    return result;
  }
}
