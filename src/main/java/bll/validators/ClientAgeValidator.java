package bll.validators;

import javax.swing.*;

/**
 * Through this class we will check if the data entered into the interface correspond to the requirements of a client  using the interface
 * @see Validator
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ClientAgeValidator implements Validator {

    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 30;

    /**
     * The main purpose of the implemented method is to check the minimum / maximum age of a client
     * @param age the age that should be checked
     * @return the status "true" when the age meets the requirements
     */

    @Override
    public boolean validate(Object age) {

        boolean ok = true;
        int x = 0;

        try {
            x = Integer.parseInt(age.toString());
        } catch (NumberFormatException e) {
            ok = false; //String is not an Integer
        }

        if (ok) {
            if (x < MIN_AGE || x > MAX_AGE) {
                JOptionPane.showMessageDialog(null, "Client's age limit is not respected!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Age is not an int");
            return false;
        }

        return true; //String is an Integer
    }
}
