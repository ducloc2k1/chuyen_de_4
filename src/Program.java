
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import product.DAO.ProductDAO;
import product.entities.Product;
import product.lang.LangI18N;

/*f
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class Program {

    public static void main(String[] args) throws IOException {
        ResourceBundle bundle = LangI18N.getBundle();
        StringBuilder table = new StringBuilder();
        String code;
        Product p;
        Scanner sc = new Scanner(System.in);
        product.DAO.ProductDAO productDAO = new ProductDAO();
        int option;
        while (true) {
            System.out.println(".: MENU :.");
            System.out.println("1. " + bundle.getString("menu1"));
            System.out.println("2. " + bundle.getString("menu2"));
            System.out.println("3. " + bundle.getString("menu3"));
            System.out.println("4. " + bundle.getString("menu4"));
            System.out.println("5. " + bundle.getString("menu5"));
            System.out.println("6. " + bundle.getString("menu6"));
            System.out.println("Nhập tùy chọn: ");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Nhập mã: ");
                    code = sc.nextLine();
                    p = productDAO.findById(code);
                    if (p != null) {
                        System.out.println(p.toString());
                        while (true) {                            
                            System.out.println("Nhập số lượng: ");
                            int soLuong = Integer.parseInt(sc.nextLine());
                            if (p.getSoLuong() <= 0) {
                                if (soLuong > 0) {
                                    p.setSoLuong(soLuong + p.getSoLuong());
                                    break;
                                }else{
                                    System.out.println("Số lượng trong kho < 0");
                                }
                            }else{
                                p.setSoLuong(soLuong + p.getSoLuong());
                            }
                        }
                        productDAO.updateProduct(p);
                    } else {
                        p = new Product();
                        p.setMaHH(code);
                        p.input();
                        productDAO.addProduct(p);
                    }
                    break;
                case 2:
                    List<Product> listProducts = new ArrayList<>();
                    FileWriter fw = new FileWriter(new File("bill.txt"));
                    float total;
                    while (true) {
                        System.out.println("Nhập mã: ");
                        code = sc.nextLine();
                        p = productDAO.findById(code);
                        if (p != null) {
                            System.out.println("Nhập số lượng: ");
                            int soLuong = Integer.parseInt(sc.nextLine());
                            if (p.getSoLuong() > soLuong) {
                                p.setSoLuong(p.getSoLuong() - soLuong);
                                productDAO.updateProduct(p);
                                p.setSoLuong(soLuong);
                                listProducts.add(p);
                                total = p.getGiaGoc()*p.getSoLuong();
                                System.out.println("bạn có muốn in phiêu xuất không? (Y/N)");
                                if (sc.nextLine().equalsIgnoreCase("y")) {
                                    String leftAlignFormat = "| %-4s | %-14s | %-8s | %-8s | %-5s |  %-4s |  %-5s     |\n";
                                    table.append("+------+----------------+----------+----------+-------+-------+------------+\n");
                                    table.append("| Id   | Name           | Supplier | Quantity | Price |  VAT  |  Total     |\n");
                                    table.append("+------+----------------+----------+----------+-------+-------+------------+\n");
                                    for (Product product : listProducts) {
                                        table.append(String.format(leftAlignFormat, product.getMaHH(), product.getTenHH(),
                                                product.getNsx(), product.getSoLuong(),
                                                product.getGiaGoc(), product.getVat(), total));
                                    }
                                    table.append("+------+----------------+----------+----------+-------+-------+------------+\n");
                                    System.out.println(table.toString());
                                    break;
                                }
                            } else {
                                System.out.println("Số lượng không đủ !!!");
                            }
                        } else {
                            System.out.println("Sản phẩm không tồn tại !!!");
                        }
                    }
                    fw.write(table.toString());
                    fw.close();
                    break;

                case 3:
                    //Sắp xếp theo tên
                    System.out.println("Sắp xếp theo tên");
                    List<Product> listProduct = productDAO.listProduct();
                    listProduct.stream().sorted((Product o1, Product o2) -> {
                        return o1.getTenHH().compareTo(o2.getTenHH()); //To change body of generated lambdas, choose Tools | Templates.
                    }).forEach((t) -> {System.out.println(t.toString());});
                    System.out.println("------------------------------------------------------------------------------");
                    //Sắp xếp theo giá
                    System.out.println("Sắp xếp theo giá");
                    listProduct.stream().sorted((Product o1, Product o2) -> {
                        return (int) (o1.getGiaGoc() - o2.getGiaGoc()); //To change body of generated lambdas, choose Tools | Templates.
                    }).forEach((t) -> {System.out.println(t.toString());});
                    System.out.println("------------------------------------------------------------------------------");
                    //Sắp xếp theo số lượng
                    System.out.println("Sắp xếp theo số lượng");
                    listProduct.stream().sorted((Product o1, Product o2) -> {
                        return o1.getSoLuong()- o2.getSoLuong(); //To change body of generated lambdas, choose Tools | Templates.
                    }).forEach((t) -> {System.out.println(t.toString());});
                    break;
                case 4:
                    System.out.println("Nhập mã: ");
                    code = sc.nextLine();
                    Product product = productDAO.findById(code);
                    if (product != null) {
                        product = new Product();
                        product.setMaHH(code);
                        product.input();
                        productDAO.updateProduct(product);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm !!!");
                    }
                    break;
                case 5: 
                    LangI18N langI18N = new LangI18N();
                    if (Locale.getDefault().getCountry().equals("VN")) {
                        System.out.println("Chọn ngôn ngữ");
                        System.out.println("1.Việt Nam");
                        System.out.println("2.Tiếng Anh");
                    }
                    if (Locale.getDefault().getCountry().equals("US")) {
                        System.out.println("Select language");
                        System.out.println("1.VietNam");
                        System.out.println("2.England");
                    }
                    int lang = Integer.parseInt(sc.nextLine());
                    if (lang == 2) {
                        bundle = ResourceBundle.getBundle("product.lang.language", Locale.US);
                    }else if(lang == 1){
                        bundle = langI18N.getBundle();
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Nhập sai!!!");
            }
        }
    }
}
