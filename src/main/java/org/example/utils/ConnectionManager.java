package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static  final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PWD_KEY = "db.pwd";

    private static ConnectionManager connectionManager = null;
    
    static{
        try {
            ScriptInitializer.runScript();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public Connection getConection() throws SQLException {

        Connection conncetion = null;
        conncetion = DriverManager.getConnection(
                PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USER_KEY),
                PropertiesUtil.get(PWD_KEY)
        );
        return conncetion;
    }

    public static ConnectionManager getInstance(){
        if (connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

}
