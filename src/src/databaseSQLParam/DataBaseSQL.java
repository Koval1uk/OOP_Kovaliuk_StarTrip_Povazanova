package src.databaseSQLParam;
import src.itemsInterface.DataBaseItemInterface;
import src.Exceptions.DataBaseExceptions;

import java.sql.*;

public class DataBaseSQL implements DataBaseItemInterface {

    private Connection connectionDB;
    private Statement statementDB;

    public Connection getConnectionDB() {
        return connectionDB;
    }

    public void setConnectionDB() throws DataBaseExceptions, SQLException {
        if (connectionDB != null)
            throw new DataBaseExceptions("Don't try again! You have already been in database.");
        connectionDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectoop", "root", "Koval1yu4ekua");
    }

    @Override
    public boolean execute(String mySql) throws DataBaseExceptions, SQLException {
        if (connectionDB == null)
            throw new DataBaseExceptions("Try again! Something went wrong with connecting to database.");

        statementDB = connectionDB.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
        return statementDB.execute(mySql);
    }

    @Override
    public ResultSet selectFromDB(String mySql) throws DataBaseExceptions, SQLException {
        if (connectionDB == null)
            throw new DataBaseExceptions("Try again! Something went wrong with connecting to database.");
        // by default this will be null
        ResultSet resultSet = null;

        statementDB = connectionDB.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
        resultSet = statementDB.executeQuery(mySql);

        return resultSet;
    }
}