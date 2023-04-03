package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class creates the appropriate interface to modify details of an existing product from the database using a superclass
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class EditProduct extends JFrame{

    private final JLabel idLabel;
    private final JTextField nameField;
    private final JTextField stockField;
    private final JTextField priceeField;
    private final JPanel contentPane;
    private final JButton ok;
    private final JComboBox<String> pb;

    public EditProduct(Connection connection) {

        setSize(450, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        setLayout(null);
        setVisible(true);


        idLabel = new JLabel("Choose product");
        idLabel.setForeground(new Color(255,51,85));
        idLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        idLabel.setBounds(40, 20, 200, 30);
        contentPane.add(idLabel);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setForeground(new Color(255,51,85));
        nameLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        nameLabel.setBounds(40, 60, 200, 30);
        contentPane.add(nameLabel);

        JLabel stockLabel = new JLabel("STOCK");
        stockLabel.setForeground(new Color(255,51,85));
        stockLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        stockLabel.setBounds(40, 100, 200, 30);
        contentPane.add(stockLabel);

        JLabel priceLabel = new JLabel("PRICE");
        priceLabel.setForeground(new Color(255,51,85));
        priceLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        priceLabel.setBounds(40, 140, 200, 30);
        contentPane.add(priceLabel);


        nameField = new JTextField();
        nameField.setForeground(Color.LIGHT_GRAY);
        nameField.setFont(new Font("Impact", Font.PLAIN, 18));
        nameField.setBounds(200, 60, 200, 30);
        contentPane.add(nameField);

        stockField = new JTextField();
        stockField.setForeground(Color.LIGHT_GRAY);
        stockField.setFont(new Font("Impact", Font.PLAIN, 18));
        stockField.setBounds(200, 100, 200, 30);
        contentPane.add(stockField);

        priceeField = new JTextField();
        priceeField.setForeground(Color.LIGHT_GRAY);
        priceeField.setFont(new Font("Impact", Font.PLAIN, 18));
        priceeField.setBounds(200, 140, 200, 30);
        contentPane.add(priceeField);

        ok =  new JButton("OK");
        ok.setOpaque(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setForeground(new Color(255,51,85));
        ok.setFont(new Font("Impact", Font.PLAIN, 20));
        ok.setBounds(260, 260, 200, 30);
        contentPane.add(ok);

        ResultSet resultSet = null;
        try {
            String sql = "SELECT id, name FROM orderdb.product";
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] product ={};
        pb=new JComboBox<>(product);

        try {
            while(resultSet.next()){
                pb.addItem(resultSet.getInt("id") + " " +
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pb.setBounds(200, 20,200,20);
        contentPane.add(pb);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getStockField() {
        return stockField;
    }

    public JTextField getPriceeField() {
        return priceeField;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getOk() {
        return ok;
    }

    public JComboBox<String> getPb() {
        return pb;
    }
}
