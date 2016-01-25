/**
 * Fraction Calculator: example to run Fraction class
 * 
 * @author Alejandro Sanchez Acosta
 */

import javax.swing.JOptionPane;

public class FractionCalculator {

  /**
   * main() method: begins program
   * 
   * @param arguments is not used
   */
  public static void main(String[] arguments) {
    FractionInterface fraction1 = new Fraction(0, 1);
    FractionInterface fraction2 = new Fraction(0, 1);
    FractionInterface fraction3 = new Fraction(0, 1);

    // Get input
    String number1 = JOptionPane.showInputDialog("Please enter the numerator");
    String number2 = JOptionPane.showInputDialog("Please enter the denominator");
    String number3 = JOptionPane.showInputDialog("Please enter the 2nd numerator");
    String number4 = JOptionPane.showInputDialog("Please enter the 2nd denominator");
    try {
      Integer numerator = Integer.parseInt(number1);
      Integer denominator = Integer.parseInt(number2);

      // Set first Fraction object
      fraction1.setNumerator(numerator);
      fraction1.setDenominator(denominator);

      // Convert String To Integer.
      numerator = Integer.parseInt(number3);
      denominator = Integer.parseInt(number4);

      // Set second Fraction object
      fraction2.setNumerator(numerator);
      fraction2.setDenominator(denominator);

      // Calculate addition
      fraction3 = fraction1.add(fraction2);
      String message = fraction1.toString() + " + " + fraction2.toString() + " = "
          + fraction3.toString();

      // Calculate subtraction
      fraction3 = fraction1.subtract(fraction2);
      message = message + "\n" + fraction1.toString() + " - " + fraction2.toString() + " = "
          + fraction3.toString();

      // Multiply
      fraction3 = fraction1.multiply(fraction2);
      message = message + "\n" + fraction1.toString() + " * " + fraction2.toString() + " = "
          + fraction3.toString();

      // Divide
      fraction3 = fraction1.divide(fraction2);
      message = message + "\n" + fraction1.toString() + " / " + fraction2.toString() + " = "
          + fraction3.toString();
      JOptionPane.showMessageDialog(null, message);
    }
    
    catch (NumberFormatException exception1) {
      JOptionPane.showMessageDialog(null, "Please enter a whole number.");
    }

    catch (IllegalFractionException exception2) {
      String message = exception2.toString();
      JOptionPane.showMessageDialog(null, message);
    }
  }
}