package com.lifesup.util;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public void executeMySQLScript() throws SQLException, FileNotFoundException {
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost:3306";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "123456a@A");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader("C:\\Users\\DELL\\intellij-workspace\\dbscript\\script.sql"));
        //Running the script
        sr.runScript(reader);
    }

    public void executeOracleScript(String schemaName) throws SQLException, FileNotFoundException {

        //Getting the connection
        String oracleUrl = "jdbc:oracle:thin:@//128.199.239.168:1521";
        Connection con = DriverManager.getConnection(oracleUrl, "system", "oracle");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        String tenantFilePath = "C:\\Users\\DELL\\intellij-workspace\\tenant-folder\\" + schemaName + ".sql";
        Reader reader = new BufferedReader(new FileReader(tenantFilePath));
        //Running the script
        sr.runScript(reader);
    }

    public void replaceSchemaName(String schemaName, String password) throws IOException {
        String originFilePath = "C:\\Users\\DELL\\intellij-workspace\\origin-script\\origin-script.sql";
        Path originPath = Paths.get(originFilePath);
        Charset charset = StandardCharsets.UTF_8;

        String schemaNameToReplace = new String(Files.readAllBytes(originPath));
        schemaNameToReplace = schemaNameToReplace.replaceAll("schemaName", schemaName)
                .replaceAll("password", password);

        String tenantFilePath = "C:\\Users\\DELL\\intellij-workspace\\tenant-folder\\" + schemaName + ".sql";
        Path newPath = Paths.get(tenantFilePath);
        Files.write(newPath, schemaNameToReplace.getBytes(charset));
    }
}
