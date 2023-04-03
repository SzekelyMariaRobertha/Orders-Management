package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class creates the appropriate interface for creating an order by giving a client, a product and a quantity for the product
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class CreateOrders extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JComboBox<String> cb;
    private final JComboBox<String> pb;
    private final JButton ok;
    private final JSpinner spinner;

    public CreateOrders(Connection connection) {

        //pt clienti
        ResultSet rs = null;
        try {
            String sql = "SELECT id, name FROM orderdb.client";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //pt produse
        ResultSet resultSet = null;
        try {
            String sql = "SELECT id, name FROM orderdb.product";
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(630, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);

        String[] client ={};
        cb=new JComboBox<>(client);

        try {
            while(rs.next()){
                cb.addItem(rs.getInt("id") + " " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cb.setBounds(30, 60,200,20);
        contentPane.add(cb);

        String[] product ={};
        pb=new JComboBox<>(product);

        try {
            while(resultSet.next()){
                pb.addItem(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pb.setBounds(280, 60,200,20);
        contentPane.add(pb);

        SpinnerModel value =
                new SpinnerNumberModel(0, //initial value
                        0, //minimum value
                        1000, //maximum value
                        1); //step
        spinner = new JSpinner(value);
        spinner.setBounds(530,60,60,20);
        contentPane.add(spinner);

        JLabel c = new JLabel("Choose client");
        c.setForeground(new Color(255,51,85));
        c.setFont(new Font("Impact", Font.PLAIN, 20));
        c.setBounds(30, 30, 150, 30);
        contentPane.add(c);


        JLabel p = new JLabel("Choose product");
        p.setForeground(new Color(255,51,85));
        p.setFont(new Font("Impact", Font.PLAIN, 20));
        p.setBounds(280, 30, 150, 30);
        contentPane.add(p);


        JLabel q = new JLabel("Quantity");
        q.setForeground(new Color(255,51,85));
        q.setFont(new Font("Impact", Font.PLAIN, 20));
        q.setBounds(525, 30, 150, 30);
        contentPane.add(q);

        ok =  new JButton("OK");
        ok.setOpaque(false);
        ok.setContentAreaFilled(false);
        ok.setBorderPainted(false);
        ok.setForeground(new Color(255,51,85));
        ok.setFont(new Font("Impact", Font.PLAIN, 20));
        ok.setBounds(200, 100, 200, 30);
        contentPane.add(ok);
    }

    public JComboBox<String> getCb() {
        return cb;
    }

    public JComboBox<String> getPb() {
        return pb;
    }

    public JButton getOk() {
        return ok;
    }

    public JSpinner getSpinner() {
        return spinner;
    }
}
