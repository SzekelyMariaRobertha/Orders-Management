package presentation;

import bll.OrderBLL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.util.logging.Level;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * This class creates the appropriate interface to give a support for choosing on what objects the user should make operations
 * @see JFrame
 * @see ClientOp
 * @see ProductOp
 * @see CreateOrders
 *
 *
 * @author Szekely Maria-Robertha
 */

public class View extends JFrame{

    private static final long serialVersionUID = 1L;

    public View (Connection connection){


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 120);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 204, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);

        JButton clientOp =  new JButton("Client Operations");
        clientOp.setOpaque(false);
        clientOp.setContentAreaFilled(false);
        clientOp.setBorderPainted(false);
        clientOp.setForeground(new Color(255,51,85));
        clientOp.setFont(new Font("Impact", Font.PLAIN, 20));
        clientOp.setBounds(20, 30, 200, 30);
        contentPane.add(clientOp);

        clientOp.addActionListener(e -> new ClientOp(connection));

        JButton productOp =  new JButton("Product Operations");
        productOp.setOpaque(false);
        productOp.setContentAreaFilled(false);
        productOp.setBorderPainted(false);
        productOp.setForeground(new Color(255,51,85));
        productOp.setFont(new Font("Impact", Font.PLAIN, 20));
        productOp.setBounds(260, 30, 200, 30);
        contentPane.add(productOp);

        productOp.addActionListener(e -> new ProductOp());

        JButton createOrders =  new JButton("Create Orders");
        createOrders.setOpaque(false);
        createOrders.setContentAreaFilled(false);
        createOrders.setBorderPainted(false);
        createOrders.setForeground(new Color(255,51,85));
        createOrders.setFont(new Font("Impact", Font.PLAIN, 20));
        createOrders.setBounds(500, 30, 200, 30);
        contentPane.add(createOrders);

        createOrders.addActionListener(e -> {

            OrderBLL orderBLL = new OrderBLL();

            try {
                orderBLL.doOrder();

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, ex.getMessage());
            }
        });
    }
}
