/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import product.entities.Category;
import product.entities.Product;
import product.help.SqlConnection;
import product.help.SqlQuery;

/**
 *
 * @author Hai Phuong
 */
public class CategoryDAO implements ICategoryDAO{
    private Connection conn = SqlConnection.getConnection();
    
    public List<Category> listCategory() {
        String sql = "{call listCategory()}";
        ResultSet rs = SqlQuery.executeQuery(sql);
        Category category;
        List<Category> lstCategory = new ArrayList<>();
        try {
            while (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"), rs.getBoolean("status"));
                lstCategory.add(category);
            }
            if (lstCategory.size() > 0) {
                return lstCategory;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }

    @Override
    public void addCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCategory(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
