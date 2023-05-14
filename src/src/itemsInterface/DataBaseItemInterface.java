package src.itemsInterface;

import src.Exceptions.DataBaseExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBaseItemInterface {

    boolean execute(String mySql) throws DataBaseExceptions, SQLException;

    ResultSet selectFromDB(String mySql) throws DataBaseExceptions, SQLException;
}
