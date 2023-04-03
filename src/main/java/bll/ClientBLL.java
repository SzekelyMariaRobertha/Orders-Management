package bll;

import java.sql.SQLException;

import connection.ConnectionFactory;
import dao.ClientDAO;

/**
 * The class determines how data from the database regarding a client is used and what it can and cannot do within the application itself
 *
 *
 * @author Szekely Maria-Robertha
 */

public class ClientBLL {

	private final ClientDAO clientDAO;

	public ClientBLL() {

		clientDAO = new ClientDAO(ConnectionFactory.getConnection());
	}

	/**
	 * The purpose of the method is to show all clients from the database
	 * @throws SQLException if the database is inaccessible or other errors that are related to the database
	 */

	public void viewAllClientsBLL() throws SQLException {
		clientDAO.viewAll();
	}

	/**
	 * The purpose of the method is to add a new client into the database
	 */

	public void addClientBLL() {
		clientDAO.addClient();
	}

	/**
	 * The purpose of the method is to delete a client from the database
	 */

	public void deleteClientBLL() {
		clientDAO.deleteClient();
	}

	/**
	 * The purpose of the method is to update details of an existing client into the database
	 */

	public void editClientBLL() {
		clientDAO.editClient();
	}
}
