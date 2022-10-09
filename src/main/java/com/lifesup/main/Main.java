package com.lifesup.main;

import com.lifesup.util.DBUtil;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        DBUtil dbUtil = new DBUtil();
        try {
            String schemaName = "ducTest3";
            String password = "123456";
            dbUtil.replaceSchemaName(schemaName, password);
            dbUtil.executeOracleScript(schemaName);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
