package bll.validators;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * Through this class we will check if the data entered into the interface correspond to the requirements of a client using the interface
 * @see Validator
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ClientPhoneValidator implements Validator {

    private static final String PHONE_PATTERN = "[0-9]+";

    /**
     * The main purpose of the implemented method is to check if the phone number introduced of a client consists only of numbers and not letters
     * @param o the phone number that should be checked
     * @return the status "true" when the phone number meets the requirements
     */

    @Override
    public boolean validate(Object o) {

        Pattern patternPhone = Pattern.compile(PHONE_PATTERN);
        if (!patternPhone.matcher((String) o).matches()) {
            JOptionPane.showMessageDialog(null, "Phone is not a valid phone number!");
            return false;
        }

        return true;
    }
}
