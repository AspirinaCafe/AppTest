/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptest.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author justi
 */
public class DBConnection {
        private BasicDataSource basicDataSource=null;

        private static DBConnection dataSource;
    private final String URL="jdbc:mysql://localhost:3306/usuario";
    private final String USER="root";
    private final String PASS="";
	
	private DBConnection() {
		
            basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);
        
          
	}
        
        public static DBConnection getInstanec(){
               if (dataSource == null) {
            dataSource = new DBConnection();
            return dataSource;
        } else {
            return dataSource;
        }
        }
	
	public  Connection getConnection() throws SQLException {
		 return this.basicDataSource.getConnection();
	}
         public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }    
}
