package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class creates the appropriate interface to add a product into the database using a superclass
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class AddProduct extends JFrame{

    private final JTextField nameField;
    private final JTextField stockField;
    private final JTextField priceField;
    private final JPanel contentPane;
    private final JButton ok;

    public AddProduct() {

        setSize(450, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        setLayout(null);
        setVisible(true);


        JLabel idLabel = new JLabel("New infos");
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

        priceField = new JTextField();
        priceField.setForeground(Color.LIGHT_GRAY);
        priceField.setFont(new Font("Impact", Font.PLAIN, 18));
        priceField.setBounds(200, 140, 200, 30);
        contentPane.add(priceField);

        ok =  new JButton("OK");
        ok.setOpaque(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setForeground(new Color(255,51,85));
        ok.setFont(new Font("Impact", Font.PLAIN, 20));
        ok.setBounds(260, 260, 200, 30);
        contentPane.add(ok);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getStockField() {
        return stockField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getOk() {
        return ok;
    }
}
