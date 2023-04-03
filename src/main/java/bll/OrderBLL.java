package bll;

import connection.ConnectionFactory;
import dao.OrderDAO;

/**
 * The class determines how data from the database regarding an order is used and what it can and cannot do within the application itself
 *
 *
 * @author Szekely Maria-Robertha
 */

public class OrderBLL {

    private final OrderDAO orderDAO;

    public OrderBLL() {

        orderDAO = new OrderDAO(ConnectionFactory.getConnection());
    }

    /**
     * The purpose of the method to give the command to create an ongoing order
     */

    public void doOrder() {
        orderDAO.makeOrder();
    }
}
