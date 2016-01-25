/**
 * Fraction Interface
 *
 * @author Alejandro Sanchez
 */

public interface  FractionInterface {
  public FractionInterface add(FractionInterface fraction2);

  public FractionInterface subtract(FractionInterface fraction2);

  public FractionInterface multiply(FractionInterface fraction2);

  public FractionInterface divide(FractionInterface fraction2);
  
  public void reduceToLowestTerms();

  public int getNumerator();

  public int getDenominator();

  public void setNumerator(int numerator);

  public void setDenominator(int numerator);
}