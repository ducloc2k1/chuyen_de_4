/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.entities;

import java.util.Scanner;
import java.util.regex.Pattern;
import product.DAO.ProductDAO;
import product.help.SqlQuery;

/**
 *
 * @author Hai Phuong
 */
public class Product {
    private String maHH;
    private String tenHH;
    private String nsx;
    private int soLuong;
    private float giaGoc;
    private float vat;

    public Product() {
    }

    public Product(String maHH, String tenHH, String nsx, int soLuong, float giaGoc, float vat) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.nsx = nsx;
        this.soLuong = soLuong;
        this.giaGoc = giaGoc;
        this.vat = vat;
    }

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(float giaGoc) {
        this.giaGoc = giaGoc;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "maHH=" + maHH + ", tenHH=" + tenHH + ", nsx=" + nsx + ", soLuong=" + soLuong + ", giaGoc=" + giaGoc + ", vat=" + vat;
    }
    
    public void input(){
        String name = "^[A-Z0-9 ]{7,}$";
        String producer = ".{1,}";
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.println("Nhập tên: ");
            this.tenHH = sc.nextLine();
            if (Pattern.matches(name, this.tenHH)) {
                break;
            }else{
                System.out.println("Tên in hoa, >6 kí tự");
            }
        }
        
        while (true) {            
            System.out.println("Nhập giá: ");
            try {
                this.giaGoc = Float.parseFloat(sc.nextLine());
                if (this.giaGoc >= 1000) {
                    break;
                }else{
                    System.out.println("Giá gốc >= 1000");
                }
            } catch (Exception e) {
                System.out.println("Kiểu dữ liệu không hợp lệ !!!");
            }
        }
        
        while (true) {            
        System.out.println("Nhập số lượng: ");
            try {
                this.soLuong = Integer.parseInt(sc.nextLine());
                if (this.soLuong > 0) {
                    break;
                }else{
                    System.out.println("Số lượng > 0");
                }
            } catch (Exception e) {
                System.out.println("Kiểu dữ liệu không hợp lệ !!!");
            }
        }
        
        while (true) {            
            System.out.println("Nhập nhà sản xuất: ");
            this.nsx = sc.nextLine();
            if (Pattern.matches(producer, this.nsx)) {
                break;
            }else{
                System.out.println("Không được bỏ trống !!!");
            }
        }
        
        while (true) {            
            try {
                System.out.println("Nhập VAT: ");
                this.vat = Float.parseFloat(sc.nextLine());
                if (this.vat > 0 && this.vat < 15) {
                    break;
                }else{
                    System.out.println("0 < VAT < 15");
                }
            } catch (Exception e) {
            }
        }
    }
    
    public static void main(String[] args) {
        Product product = new Product();
        product.input();
    }
}
