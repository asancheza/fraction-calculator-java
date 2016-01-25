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

  public Integer getNumerator();

  public Integer getDenominator();

  public void setNumerator(Integer numerator);

  public void setDenominator(Integer numerator);
}
