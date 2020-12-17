/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import product.entities.Product;
import product.help.SqlQuery;

/**
 *
 * @author Hai Phuong
 */
public class ProductDAO implements IProductDAO {

    @Override
    public List<Product> listProduct() {
        List<Product> products = new ArrayList<>();
        Product product;
        ResultSet resultSet = SqlQuery.executeQuery("{call Products_List()}");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    product = new Product();
                    product.setMaHH(resultSet.getString("id"));
                    product.setTenHH(resultSet.getString("name"));
                    product.setGiaGoc(resultSet.getFloat("price"));
                    product.setNsx(resultSet.getString("producer"));
                    product.setSoLuong(resultSet.getInt("quantity"));
                    product.setVat(resultSet.getFloat("vat"));
                    product.setCategory_id(resultSet.getInt("category_id"));
                    products.add(product);
                }
                return products;
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Không có bản ghi");
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        if (product != null) {
            SqlQuery.executeUpdate("{call Add_New_Product(?,?,?,?,?,?,?)}", product.getMaHH(), product.getTenHH(),
                    product.getNsx(), product.getSoLuong(),
                    product.getGiaGoc(), product.getVat(), product.getCategory_id());
        }
    }

    @Override
    public Product findById(String id) {
        Product product = new Product();
        try {
            ResultSet resultSet = SqlQuery.executeQuery("{call Find_By_Id(?)}", id);
            if (resultSet.next()) {
                product.setMaHH(resultSet.getString("id"));
                product.setTenHH(resultSet.getString("name"));
                product.setGiaGoc(resultSet.getFloat("price"));
                product.setNsx(resultSet.getString("producer"));
                product.setSoLuong(resultSet.getInt("quantity"));
                product.setVat(resultSet.getFloat("vat"));
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateProduct(Product product) {
        if (product != null) {
            SqlQuery.executeUpdate("{call Update_Product(?,?,?,?,?,?,?)}", product.getMaHH(), product.getTenHH(),
                    product.getNsx(), product.getSoLuong(),
                    product.getGiaGoc(), product.getVat(), product.getCategory_id());
        }
    }

    @Override
    public void removeProduct(String id) {
        SqlQuery.executeUpdate("{call Remove(?)}", id);
    }
    
//    public static void main(String[] args) {
//        ProductDAO productDAO = new ProductDAO();
//        productDAO.findById("SP02");
//    }
}
