package presentation;

import bll.ClientBLL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.util.logging.Level;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * This class creates the appropriate interface to show the available operations on a client or the table of clients from the database
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ClientOp extends JFrame {

    private static final long serialVersionUID = 1L;

    public ClientOp(Connection connection) {

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


        JButton addClient = new JButton("Add Client");
        addClient.setOpaque(false);
        addClient.setContentAreaFilled(false);
        addClient.setBorderPainted(false);
        addClient.setForeground(new Color(255, 51, 85));
        addClient.setFont(new Font("Impact", Font.PLAIN, 18));
        addClient.setBounds(50, 30, 200, 30);
        contentPane.add(addClient);

        addClient.addActionListener(e -> {

            ClientBLL clientBll = new ClientBLL();

            try {
                clientBll.addClientBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });

        JButton editClient = new JButton("Edit Client");
        editClient.setOpaque(false);
        editClient.setContentAreaFilled(false);
        editClient.setBorderPainted(false);
        editClient.setForeground(new Color(255, 51, 85));
        editClient.setFont(new Font("Impact", Font.PLAIN, 18));
        editClient.setBounds(50, 70, 200, 30);
        contentPane.add(editClient);

        editClient.addActionListener(e -> {

            ClientBLL clientBll = new ClientBLL();

            try {
                clientBll.editClientBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });

        JButton deleteClient = new JButton("Delete Client");
        deleteClient.setOpaque(false);
        deleteClient.setContentAreaFilled(false);
        deleteClient.setBorderPainted(false);
        deleteClient.setForeground(new Color(255, 51, 85));
        deleteClient.setFont(new Font("Impact", Font.PLAIN, 18));
        deleteClient.setBounds(50, 110, 200, 30);
        contentPane.add(deleteClient);

        deleteClient.addActionListener(e -> {

            ClientBLL clientBll = new ClientBLL();

            try {
                clientBll.deleteClientBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });

        JButton viewAll = new JButton("View All Clients");
        viewAll.setOpaque(false);
        viewAll.setContentAreaFilled(false);
        viewAll.setBorderPainted(false);
        viewAll.setForeground(new Color(255, 51, 85));
        viewAll.setFont(new Font("Impact", Font.PLAIN, 18));
        viewAll.setBounds(50, 150, 200, 30);
        contentPane.add(viewAll);

        viewAll.addActionListener(e -> {

            ClientBLL clientBll = new ClientBLL();

            try {
                clientBll.viewAllClientsBLL();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });
    }
}
