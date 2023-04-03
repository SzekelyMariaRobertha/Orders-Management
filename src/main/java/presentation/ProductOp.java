package presentation;

import bll.ProductBLL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.logging.Level;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * This class creates the appropriate interface to show the available operations on a product or the table of products from the database
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ProductOp extends JFrame {
    private static final long serialVersionUID = 1L;

    public ProductOp() {

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);

        JButton addProduct =  new JButton("Add Product");
        addProduct.setOpaque(false);
        addProduct.setContentAreaFilled(false);
        addProduct.setBorderPainted(false);
        addProduct.setForeground(new Color(255,51,85));
        addProduct.setFont(new Font("Impact", Font.PLAIN, 18));
        addProduct.setBounds(50, 30, 200, 30);
        contentPane.add(addProduct);

        addProduct.addActionListener(e -> {

            ProductBLL productBll = new ProductBLL();

            try {
                productBll.addProductBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });

        JButton editProduct =  new JButton("Edit Product");
        editProduct.setOpaque(false);
        editProduct.setContentAreaFilled(false);
        editProduct.setBorderPainted(false);
        editProduct.setForeground(new Color(255,51,85));
        editProduct.setFont(new Font("Impact", Font.PLAIN, 18));
        editProduct.setBounds(50, 70, 200, 30);
        contentPane.add(editProduct);

        editProduct.addActionListener(e -> {

            ProductBLL productBll = new ProductBLL();

            try {
                productBll.editProductBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });

        JButton deleteProduct =  new JButton("Delete Product");
        deleteProduct.setOpaque(false);
        deleteProduct.setContentAreaFilled(false);
        deleteProduct.setBorderPainted(false);
        deleteProduct.setForeground(new Color(255,51,85));
        deleteProduct.setFont(new Font("Impact", Font.PLAIN, 18));
        deleteProduct.setBounds(50, 110, 200, 30);
        contentPane.add(deleteProduct);

        deleteProduct.addActionListener(e -> {

            ProductBLL productBll = new ProductBLL();

            try {
                productBll.deleteProductBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });

        JButton viewAll =  new JButton("View All Products");
        viewAll.setOpaque(false);
        viewAll.setContentAreaFilled(false);
        viewAll.setBorderPainted(false);
        viewAll.setForeground(new Color(255,51,85));
        viewAll.setFont(new Font("Impact", Font.PLAIN, 18));
        viewAll.setBounds(50, 150, 200, 30);
        contentPane.add(viewAll);

        viewAll.addActionListener(e -> {

            ProductBLL productBll = new ProductBLL();

            try {
                productBll.viewAllProductsBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });
    }
}
