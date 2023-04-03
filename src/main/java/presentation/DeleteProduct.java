package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class creates the appropriate interface to delete a product from the database using a superclass
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class DeleteProduct extends JFrame{

    private static final long serialVersionUID = 1L;
    private final JComboBox<String> pb;
    private final JButton ok;

    public DeleteProduct(Connection connection) {

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);

        JLabel c = new JLabel("Choose product");
        c.setForeground(new Color(255,51,85));
        c.setFont(new Font("Impact", Font.PLAIN, 20));
        c.setBounds(30, 30, 150, 30);
        contentPane.add(c);

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
                pb.addItem(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pb.setBounds(30, 60,200,20);
        contentPane.add(pb);

        ok =  new JButton("OK");
        ok.setOpaque(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setForeground(new Color(255,51,85));
        ok.setFont(new Font("Impact", Font.PLAIN, 20));
        ok.setBounds(260, 50, 200, 30);
        contentPane.add(ok);
    }

    public JButton getOk() {
        return ok;
    }

    public JComboBox<String> getPb() {
        return pb;
    }
}
