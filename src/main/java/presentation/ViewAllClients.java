package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class creates the appropriate interface to give a support for the JTable in which will be displayed all clients from the database using a superclass
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ViewAllClients extends JFrame {

    public ViewAllClients() {

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(930, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        setVisible(true);
    }
}
