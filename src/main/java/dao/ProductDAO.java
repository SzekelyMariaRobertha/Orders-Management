package dao;

import bll.validators.*;
import model.Product;
import presentation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Through this class we will perform CRUD operations on products from database or new products using a superclass
 * @see AbstractDAO
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ProductDAO extends AbstractDAO<Product> {

    private Connection connection;
    private AddProduct addProductI;
    private EditProduct editProductI;
    private DeleteProduct deleteProductI;
    private ViewAllProducts viewAllProductsI;
    private Statement statement;

    public ProductDAO(Connection connection) {
        this.connection = connection;

        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() throws SQLException {

        viewAllProductsI = new ViewAllProducts();
        ResultSet rs = statement.executeQuery("SELECT * FROM orderdb.product;");
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"));
            products.add(p);
        }

        JTable jTable = new JTable(findAll(products));
        viewAllProductsI.setLayout(new BorderLayout());
        viewAllProductsI.add(new JScrollPane(jTable), BorderLayout.CENTER);
        viewAllProductsI.add(jTable.getTableHeader(), BorderLayout.NORTH);
    }

    public void addProduct() {

        addProductI = new AddProduct();
        addProductI.getOk().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addProductI.getOk().isEnabled()) {
                    if (!addProductI.getNameField().getText().equals("") && !addProductI.getStockField().getText().equals("") && !addProductI.getPriceField().getText().equals("")) {

                        ProductNameValidator productNameValidator = new ProductNameValidator();
                        ProductStockValidator productStockValidator = new ProductStockValidator();
                        ProductPriceValidator productPriceValidator = new ProductPriceValidator();

                        if (productNameValidator.validate(addProductI.getNameField().getText()) && productStockValidator.validate(addProductI.getStockField().getText()) && productPriceValidator.validate(addProductI.getPriceField().getText())) {
                            Product newProduct = new Product(0, addProductI.getNameField().getText(), Integer.parseInt(addProductI.getStockField().getText()), Double.parseDouble(addProductI.getPriceField().getText()));
                            insert(newProduct);
                            addProductI.dispose();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Complete all textfields!");
                    }
                }
            }
        });
    }

    public void deleteProduct() {

        deleteProductI = new DeleteProduct(connection);
        deleteProductI.getPb().addActionListener(ee -> {

            deleteProductI.getOk().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (deleteProductI.getOk().isEnabled()) {

                        String x = String.valueOf(deleteProductI.getPb().getSelectedItem());
                        String[] s = x.split(" ");
                        int id = Integer.parseInt(s[0]);
                        delete(new Product(0, null, 0, 0 ), id);
                        deleteProductI.dispose();
                    }
                }
            });
        });
    }

    public void editProduct() {
        editProductI = new EditProduct(connection);
        JOptionPane.showMessageDialog(null, "Please fill in only the box with the information you want to change");
        editProductI.getPb().addActionListener(ee -> {

            editProductI.getOk().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (editProductI.getOk().isEnabled()) {

                        String x = String.valueOf(editProductI.getPb().getSelectedItem());
                        String[] s = x.split(" ");
                        int id = Integer.parseInt(s[0]);

                        if (!editProductI.getNameField().getText().equals("")){
                            ProductNameValidator productNameValidator = new ProductNameValidator();

                            if(productNameValidator.validate(editProductI.getNameField().getText())){
                                update(new Product(0, null, 0, 0), id, "name", editProductI.getNameField().getText());
                            }
                        }

                        if (!editProductI.getStockField().getText().equals("")){
                            ProductStockValidator productStockValidator = new ProductStockValidator();

                            if(productStockValidator.validate(editProductI.getStockField().getText())){
                                update(new Product(0, null, 0, 0), id, "stock", editProductI.getStockField().getText());
                            }
                        }

                        if (!editProductI.getPriceeField().getText().equals("")){
                            ProductPriceValidator productPriceValidator = new ProductPriceValidator();

                            if(productPriceValidator.validate(editProductI.getPriceeField().getText())){
                                update(new Product( 0, null, 0, 0), id, "price", editProductI.getPriceeField().getText());
                            }
                        }
                    }
                }
            });
        });
    }
}