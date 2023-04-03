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

public class ClientNameValidator implements Validator {

    private static final String NAME_PATTERN = "[a-zA-Z]+";

    /**
     * The main purpose of the implemented method is to check if the name introduced of a client consists only of letters and not numbers
     * @param o the name that should be checked
     * @return the status "true" when the name meets the requirements
     */

    @Override
    public boolean validate(Object o) {

        Pattern patternName = Pattern.compile(NAME_PATTERN);
        if (!patternName.matcher((String) o).matches()) {
            JOptionPane.showMessageDialog(null, "Not a valid name!");
            return false;
        }

        return true;
    }
}
