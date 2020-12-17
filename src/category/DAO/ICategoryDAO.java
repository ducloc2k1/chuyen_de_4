/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package category.DAO;

import java.util.List;
import product.entities.Category;
import product.entities.Product;

/**
 *
 * @author Hai Phuong
 */
public interface ICategoryDAO {
    public List<Category> listCategory();
    public void addCategory(Category category);
    public Product findById(int id);
    public void updateCategory(Category category);
    public void removeCategory(int id);
}
