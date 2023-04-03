package bll.validators;

import javax.swing.*;

/**
 * Through this class we will check if the data entered into the interface correspond to the requirements of a client using the interface
 * @see Validator
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ProductPriceValidator implements Validator {

    private static final int MIN_VALUE= 1;

    /**
     * The main purpose of the implemented method is to check if the product price introduced consists only of numbers and not letters, and it's not negative
     * @param o the price that should be checked
     * @return the status "true" when the price meets the requirements
     */

    @Override
    public boolean validate(Object o) {

        boolean ok = true;
        double x = 0;


        try {
            x = Double.parseDouble(o.toString());
        } catch (NumberFormatException e) {
            ok = false; //String is not an Integer
        }

        if (ok) {
            if (x < MIN_VALUE) {
                JOptionPane.showMessageDialog(null, "The product must cost at least 1 leu!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Price is not a double");
            return false;
        }

        return true;
    }
}
