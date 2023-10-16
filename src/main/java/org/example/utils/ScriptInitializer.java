package org.example.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

public class ScriptInitializer {
    public static void runScript() throws SQLException {
        try (Connection connection = ConnectionManager.getInstance().getConection()) {
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader("src/main/resources/init.sql"));
            sr.runScript(reader);
            System.out.println("Script run Successfully");
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

