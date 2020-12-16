/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.help;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hai Phuong
 */
public class SqlQuery {

    public static ResultSet executeQuery(String sql, Object... params) {
        Connection conn = SqlConnection.getConnection();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            if (params.length > 0) {
                int i = 1;
                for (Object p : params) {
                    cs.setObject(i, p);
                    i++;
                }
            }
            return cs.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static int executeUpdate(String sql, Object... params) {
        Connection conn = SqlConnection.getConnection();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            if (params.length > 0) {
                int i = 1;
                for (Object p : params) {
                    cs.setObject(i, p);
                    i++;
                }
            }
            return cs.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }
}
