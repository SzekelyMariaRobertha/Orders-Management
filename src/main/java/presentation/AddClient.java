package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class creates the appropriate interface to add a client into the database using a superclass
 * @see JFrame
 *
 *
 * @author Szekely Maria-Robertha
 */

public class AddClient extends JFrame{

    private final JTextField nameField;
    private final JTextField addressField;
    private final JTextField ageField;
    private final JTextField emailField;
    private final JTextField telField;
    private final JPanel contentPane;
    private final JButton ok;

    public AddClient() {

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

        JLabel addressLabel = new JLabel("ADDRESS");
        addressLabel.setForeground(new Color(255,51,85));
        addressLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        addressLabel.setBounds(40, 100, 200, 30);
        contentPane.add(addressLabel);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setForeground(new Color(255,51,85));
        ageLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        ageLabel.setBounds(40, 140, 200, 30);
        contentPane.add(ageLabel);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setForeground(new Color(255,51,85));
        emailLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        emailLabel.setBounds(40, 180, 200, 30);
        contentPane.add(emailLabel);

        JLabel phoneLabel = new JLabel("PHONE");
        phoneLabel.setForeground(new Color(255,51,85));
        phoneLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        phoneLabel.setBounds(40, 220, 200, 30);
        contentPane.add(phoneLabel);

        nameField = new JTextField();
        nameField.setForeground(Color.LIGHT_GRAY);
        nameField.setFont(new Font("Impact", Font.PLAIN, 18));
        nameField.setBounds(200, 60, 200, 30);
        contentPane.add(nameField);

        addressField = new JTextField();
        addressField.setForeground(Color.LIGHT_GRAY);
        addressField.setFont(new Font("Impact", Font.PLAIN, 18));
        addressField.setBounds(200, 100, 200, 30);
        contentPane.add(addressField);

        ageField = new JTextField();
        ageField.setForeground(Color.LIGHT_GRAY);
        ageField.setFont(new Font("Impact", Font.PLAIN, 18));
        ageField.setBounds(200, 140, 200, 30);
        contentPane.add(ageField);

        emailField = new JTextField();
        emailField.setForeground(Color.LIGHT_GRAY);
        emailField.setFont(new Font("Impact", Font.PLAIN, 18));
        emailField.setBounds(200, 180, 200, 30);
        contentPane.add(emailField);

        telField = new JTextField();
        telField.setForeground(Color.LIGHT_GRAY);
        telField.setFont(new Font("Impact", Font.PLAIN, 18));
        telField.setBounds(200, 220, 200, 30);
        contentPane.add(telField);

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

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getAgeField() {
        return ageField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getTelField() {
        return telField;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getOk() {
        return ok;
    }
}
