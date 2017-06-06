package Data.insertintoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData_Table {
	private final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:orcl"; // change
	// here
	private final String DB_USER = "Arif"; // change here
	private final String DB_PASSWORD = "Arif"; // change here

private Connection getDBConnection() {
	Connection dbConnection = null;
	try {
	Class.forName(DB_DRIVER);
	} catch (ClassNotFoundException e) {
	System.out.println(e.getMessage());
	}
	try {
	dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	return dbConnection;
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	}
	return dbConnection;
	}

public void loadData(int noOfRec) throws SQLException {
	Connection dbConnection = null;
	Statement statement = null;

	try {
	dbConnection = getDBConnection();
	statement = dbConnection.createStatement();
	for (int i = 1; i < (noOfRec + 1); i++) {
	statement.executeQuery(
	"INSERT INTO candidate VALUES('john" + i + "', '212345" + i + "', 'qa" + i + "')");
	}
	System.out.println("Data has been loaded into table!");

	} catch (SQLException e) {
	System.out.println(e.getMessage());
	} finally {
	if (statement != null) {
	statement.close();
	}
	if (dbConnection != null) {
	dbConnection.close();
	}
	}
	}

	


	


}
