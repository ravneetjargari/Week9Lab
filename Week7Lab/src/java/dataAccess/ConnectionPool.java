
package dataAccess;


import java.sql.*;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.InitialContext;

/**
 *
 * @author ravne
 */
public class ConnectionPool{
    private static ConnectionPool cp=null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        try{
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/userdb");
        } catch (NamingException e){
            System.out.println(e);
        }
    }
    public static synchronized ConnectionPool getInstance(){
        if(cp == null){
            cp = new ConnectionPool();
        }
        return cp;
    }
    public Connection getConnection(){
        try{
            return dataSource.getConnection();
        }catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public void freeConnection(Connection c){
        try{
            c.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
