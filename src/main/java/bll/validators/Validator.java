package bll.validators;

/**
 * This class represents an interface implemented by other classes to validate the data entered into the interface by the user
 * Classes that implements this interface:
 * @see ClientAgeValidator
 * @see ClientEmailValidator
 * @see ClientNameValidator
 * @see ClientPhoneValidator
 * @see ProductNameValidator
 * @see ProductPriceValidator
 * @see ProductStockValidator
 *
 *
 * @author Szekely Maria-Robertha
 */

public interface Validator<T> {

	boolean validate(T t);
}
