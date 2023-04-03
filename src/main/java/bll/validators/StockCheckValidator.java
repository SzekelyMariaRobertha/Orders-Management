package bll.validators;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Through this class we will check if the warehouse still has enough products to complete the order successfully
 *
 *
 * @author Szekely Maria-Robertha
 */

public class StockCheckValidator {

    /**
     * The main purpose of the implemented method is to check if there are enough products in stock to complete the order successfully
     * @param o the product that should be checked
     * @param q the value with which the stock of the warehouse must be compared
     * @return the status "true" when the stock value is greater than the quantity required to order
     */

    public boolean validate(Object o, int q) {

        Connection connection = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("SELECT stock FROM orderdb.Product WHERE id = ?");
        int stock = -1;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, String.valueOf(o));
            ResultSet rs =  preparedStatement.executeQuery();

            while(rs.next()){
                stock = rs.getInt("stock");
            }

            return q <= stock;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
