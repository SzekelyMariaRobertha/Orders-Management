package start;

import connection.ConnectionFactory;
import presentation.View;

/**
 * This class represent the controller of the application
 * Here is the point where the application runs
 *
 *
 * @author Szekely Maria-Robertha
 */

public class Start {

	public static void main(String[] args){
		new View(ConnectionFactory.getConnection());
	}
}
