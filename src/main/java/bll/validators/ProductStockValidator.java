package bll.validators;

import javax.swing.*;

/**
 * Through this class we will check if the data entered into the interface correspond to the requirements of a client using the interface
 * @see Validator
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ProductStockValidator implements Validator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 1000;

    /**
     * The main purpose of the implemented method is to check if the product stock introduced consists only of numbers and not letters, and it's not negative
     * @param stock the stock that should be checked
     * @return the status "true" when the stock meets the requirements
     */

    @Override
    public boolean validate(Object stock) {

        boolean ok = true;
        int x = 0;

        try {
            x = Integer.parseInt(stock.toString());
        } catch (NumberFormatException e) {
            ok = false; //String is not an Integer
        }

        if (ok) {
            if (x < MIN_VALUE || x > MAX_VALUE) {
                JOptionPane.showMessageDialog(null, "There must be at least one such product in stock and a maximum of 1000!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Stock is not an int");
            return false;
        }

        return true; //String is an Integer
    }
}
