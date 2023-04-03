package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class creates the appropriate interface to delete a client from the database using a superclass
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class DeleteClient extends JFrame{

    private static final long serialVersionUID = 1L;
    private final JComboBox<String> cb;
    private final JButton ok;

    public DeleteClient(Connection connection) {

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

        JLabel c = new JLabel("Choose client");
        c.setForeground(new Color(255,51,85));
        c.setFont(new Font("Impact", Font.PLAIN, 20));
        c.setBounds(30, 30, 150, 30);
        contentPane.add(c);

        //pt clienti
        ResultSet rs = null;
        try {
            String sql = "SELECT id, name FROM orderdb.client";
            PreparedStatement statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    public JComboBox<String> getCb() {
        return cb;
    }
}
