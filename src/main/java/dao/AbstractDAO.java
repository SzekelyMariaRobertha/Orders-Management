package dao;

import connection.ConnectionFactory;
import model.Client;
import model.Order;
import model.Product;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO is a pattern that provides an abstract interface to some type of database or other persistence mechanism
 * @see "http://www.java-blog.com/mapping-javaobjects-database-reflection-generics"
 *
 *
 * @author Szekely Maria-Robertha
 */

public class AbstractDAO<T> {

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * The purpose of the method is to create a model for a JTable in order to show all clients from tha database in the form of a table
     * @param list list of clients from database
     * @return the model for a JTable
     */

    public TableModel findAll(List<?> list) {

        DefaultTableModel tableModel = new DefaultTableModel();
        List<String> columns = new ArrayList<>();
        for (java.lang.reflect.Field field : list.get(0).getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columns.add(field.getName());
        }
        tableModel.setColumnIdentifiers(columns.toArray());

        for (Object o : list) {
            Object[] value = new Object[list.get(0).getClass().getDeclaredFields().length];
            int poz = 0;
            for (Field field : o.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    value[poz] = field.get(o);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                poz++;
            }
            tableModel.addRow(value);
        }
        return tableModel;
    }

    /**
     * The purpose of the method is to insert a new object into the database
     * @param t the object that should be inserted into the database
     */

    public void insert(Object t) {

        String table = t.getClass().getSimpleName();

        if (t instanceof Order) {
            table += "r";
        }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO orderdb." + table + " (");

        for (int i = 1; i < t.getClass().getDeclaredFields().length; i++) {
            Field field = t.getClass().getDeclaredFields()[i];
            field.setAccessible(true);

            if (i == t.getClass().getDeclaredFields().length - 1) {
                sql.append(field.getName() + ") VALUES (");
            } else {
                sql.append(field.getName() + ", ");
            }
        }

        if (t instanceof Client) {
            sql.append("'" + ((Client) t).getName() + "', " + "'" + ((Client) t).getAddress() + "', " + "" + ((Client) t).getAge() + ", " + "'" + ((Client) t).getEmail() + "', " + "'" + ((Client) t).getPhoneNr() + "');");

        } else if (t instanceof Product) {
            sql.append("'" + ((Product) t).getName() + "', " + "" + ((Product) t).getStock() + ", " + "" + ((Product) t).getPrice() + ");");

        } else if (t instanceof Order) {
            sql.append(((Order) t).getClientID() + ", '" + ((Order) t).getClientName() + "', " + ((Order) t).getProductID() + ", '" + ((Order) t).getProductName() + "', " + ((Order) t).getQuantity() + ", " + ((Order) t).getPrice() + ");");
        }

        System.out.println(sql);

        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The purpose of the method is to update details of client into the database
     * @param t a general object in order to get its class for getting the correct name of the table from database
     * @param i the id of the object that should be modified
     * @param c the field that should be modified into the database
     * @param with new information that will replace old data about the object
     */

    public void update(Object t, int i, String c, String with) {
        Connection connection = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("UPDATE orderdb.");
        String table = t.getClass().getSimpleName();
        sql.append(table + " set " + c + " = ? WHERE id = ?");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, with);
            preparedStatement.setInt(2, i);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * The purpose of the method is to delete an object from the database
     * @param t a general object in order to get its class for getting the correct name of the table from database
     * @param i the id of the object that should be deleted
     */

    public void delete(Object t, int i) {

        Connection connection = ConnectionFactory.getConnection();
        StringBuilder sql = new StringBuilder("DELETE FROM orderdb.");
        sql.append(t.getClass().getSimpleName() + " WHERE id = ?");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, i);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
