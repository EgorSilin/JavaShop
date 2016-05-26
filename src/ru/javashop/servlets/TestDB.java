package ru.javashop.servlets;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 * Created by Admin on 24.05.2016.
 */
public class TestDB {
    public ArrayList<String> dbList = new ArrayList<String>();

    public void checkDB() {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("jdbc/javashopdb");
            Connection conn = ds.getConnection();
            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("use javashopdb");
//            rs.
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                dbList.add("<p>" + rs.getString("name") + "</p>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
