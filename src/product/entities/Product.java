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
    private int category_id;

    public Product() {
    }

    public Product(String maHH, String tenHH, String nsx, int soLuong, float giaGoc, float vat, int category_id) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.nsx = nsx;
        this.soLuong = soLuong;
        this.giaGoc = giaGoc;
        this.vat = vat;
        this.category_id = category_id;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    
}
