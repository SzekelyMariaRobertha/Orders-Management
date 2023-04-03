package dao;

import bll.validators.*;
import model.Client;
import presentation.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;

/**
 * Through this class we will perform CRUD operations on clients from database or new clients using a superclass
 * @see AbstractDAO
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ClientDAO extends AbstractDAO<Client> {

    private final Connection connection;
    private AddClient addClientI;
    private EditClient editClientI;
    private DeleteClient deleteClientI;
    private ViewAllClients viewAllClientsI;
    private Statement statement;

    public ClientDAO(Connection connection) {
        this.connection = connection;

        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAll() throws SQLException {

        viewAllClientsI = new ViewAllClients();
        ResultSet rs = statement.executeQuery("SELECT * FROM orderdb.client;");
        List<Client> clients = new ArrayList<>();
        while (rs.next()) {
            Client c = new Client(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getInt("age"), rs.getString("email"), rs.getString("phoneNr"));
            clients.add(c);
        }

        JTable jTable = new JTable(findAll(clients));
        viewAllClientsI.setLayout(new BorderLayout());
        viewAllClientsI.add(new JScrollPane(jTable), BorderLayout.CENTER);
        viewAllClientsI.add(jTable.getTableHeader(), BorderLayout.NORTH);
    }

    public void addClient() {

        addClientI = new AddClient();
        addClientI.getOk().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (addClientI.getOk().isEnabled()) {
                    if (!addClientI.getNameField().getText().equals("") && !addClientI.getAddressField().getText().equals("") && !addClientI.getAgeField().getText().equals("") && !addClientI.getEmailField().getText().equals("") && !addClientI.getTelField().getText().equals("")) {

                        ClientNameValidator clientNameValidator = new ClientNameValidator();
                        ClientAgeValidator clientAgeValidator = new ClientAgeValidator();
                        ClientEmailValidator clientEmailValidator = new ClientEmailValidator();
                        ClientPhoneValidator clientPhoneValidator = new ClientPhoneValidator();

                        if (clientNameValidator.validate(addClientI.getNameField().getText()) && clientAgeValidator.validate(addClientI.getAgeField().getText()) && clientEmailValidator.validate(addClientI.getEmailField().getText()) && clientPhoneValidator.validate(addClientI.getTelField().getText())) {
                            Client newClient = new Client(0, addClientI.getNameField().getText(), addClientI.getAddressField().getText(), Integer.parseInt(addClientI.getAgeField().getText()), addClientI.getEmailField().getText(), addClientI.getTelField().getText());
                            insert(newClient);
                            addClientI.dispose();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Complete all text fields!");
                    }
                }
            }
        });
    }

    public void deleteClient() {

        deleteClientI = new DeleteClient(connection);
        deleteClientI.getCb().addActionListener(ee -> {

            deleteClientI.getOk().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (deleteClientI.getOk().isEnabled()) {

                        String x = String.valueOf(deleteClientI.getCb().getSelectedItem());
                        String[] s = x.split(" ");
                        int id = Integer.parseInt(s[0]);
                        delete(new Client(0, null, null, 0, null, null), id);
                        deleteClientI.dispose();
                    }
                }
            });
        });
    }

    public void editClient() {
        editClientI = new EditClient(connection);
        JOptionPane.showMessageDialog(null, "Please fill in only the box with the information you want to change");
        editClientI.getCb().addActionListener(ee -> {

            editClientI.getOk().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (editClientI.getOk().isEnabled()) {

                        String x = String.valueOf(editClientI.getCb().getSelectedItem());
                        String[] s = x.split(" ");
                        int id = Integer.parseInt(s[0]);

                        if (!editClientI.getNameField().getText().equals("")){
                            ClientNameValidator clientNameValidator = new ClientNameValidator();

                            if (clientNameValidator.validate(editClientI.getNameField().getText())) {
                                update(new Client(0, null, null, 0, null, null), id, "name", editClientI.getNameField().getText());
                            }
                        }

                        if (!editClientI.getAddressField().getText().equals("")){

                            update(new Client(0, null, null, 0, null, null), id, "address", editClientI.getAddressField().getText());
                        }

                        if (!editClientI.getAgeField().getText().equals("")){
                            ClientAgeValidator clientAgeValidator = new ClientAgeValidator();

                            if (clientAgeValidator.validate(editClientI.getAgeField().getText())) {
                                update(new Client(0, null, null, 0, null, null), id, "age", editClientI.getAgeField().getText());

                            }
                        }

                        if (!editClientI.getEmailField().getText().equals("")){
                            ClientEmailValidator clientEmailValidator = new ClientEmailValidator();

                            if (clientEmailValidator.validate(editClientI.getEmailField().getText())) {
                                update(new Client(0, null, null, 0, null, null), id, "email", editClientI.getEmailField().getText());
                            }
                        }

                        if (!editClientI.getTelField().getText().equals("")){
                            ClientPhoneValidator clientPhoneValidator = new ClientPhoneValidator();

                            if (clientPhoneValidator.validate(editClientI.getTelField().getText())) {
                                update(new Client(0, null, null, 0, null, null), id, "phoneNr", editClientI.getTelField().getText());
                            }
                        }
                    }
                }
            });
        });

    }
}
