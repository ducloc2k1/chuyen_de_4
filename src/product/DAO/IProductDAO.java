/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.DAO;

import java.util.List;
import product.entities.Product;

/**
 *
 * @author Hai Phuong
 */
public interface IProductDAO {
    public List<Product> listProduct();
    public void addProduct(Product product);
    public Product findById(String id);
    public void updateProduct(Product product);
    public void removeProduct(String id);
}
