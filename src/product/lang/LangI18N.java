/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.lang;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Hai Phuong
 */
public class LangI18N {
    public static Locale LOCALE = new Locale("vi", "VN");
    
    public static ResourceBundle getBundle(){
        return ResourceBundle.getBundle("product.lang.language", LOCALE);
    }
}
