package club.bestchu.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by bestchu on 2017/7/14.
 */
public class JdbcUtil {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driver = null;

    static{
        Properties props = new Properties();
        InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
        try {
            props.load(in);
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            driver = props.getProperty("driverClass");
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void close(Connection conn, Statement stm, ResultSet rs){
        if(stm != null){
            try {
                stm.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }
}


