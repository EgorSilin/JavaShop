package ru.javashop.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import ru.javashop.classes.Category;
import ru.javashop.classes.Database;

@ManagedBean
@ApplicationScoped
public class Categories implements Serializable{

    private ArrayList<Category> categoryList = new ArrayList<Category>();

    private ArrayList<Category> getCategories() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from categories order by name");
//            rs = stmt.executeQuery("select * from categories");
            while (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString("name"));
                category.setId(rs.getLong("id"));
                categoryList.add(category);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return categoryList;
    }

    public ArrayList<Category> getCategoryList() {
        if (!categoryList.isEmpty()) {
            return categoryList;
        } else {
            return getCategories();
        }
    }
}

