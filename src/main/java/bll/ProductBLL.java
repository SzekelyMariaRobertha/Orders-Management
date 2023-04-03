package bll;

import java.sql.SQLException;
import connection.ConnectionFactory;
import dao.ProductDAO;

/**
 * The class determines how data from the database regarding a product is used and what it can and cannot do within the application itself
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ProductBLL {

    private final ProductDAO productDAO;

    public ProductBLL() {

        productDAO = new ProductDAO(ConnectionFactory.getConnection());
    }

    /**
     * The purpose of the method is to show all products from the database
     * @throws SQLException if the database is inaccessible or other errors that are related to the database
     */

    public void viewAllProductsBLL() throws SQLException {
        productDAO.viewAll();
    }

    /**
     * The purpose of the method is to add a new product into the database
     */

    public void addProductBLL() {
        productDAO.addProduct();
    }

    /**
     * The purpose of the method is to delete a product from the database
     */

    public void deleteProductBLL() {
        productDAO.deleteProduct();
    }

    /**
     * The purpose of the method is to update details of an existing product into the database
     */

    public void editProductBLL() {
        productDAO.editProduct();
    }
}
