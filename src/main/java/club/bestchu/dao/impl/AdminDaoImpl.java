package club.bestchu.dao.impl;

import club.bestchu.dao.AdminDao;
import club.bestchu.entity.Admin;
import club.bestchu.utils.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by bestchu on 2017/7/14.
 */
public class AdminDaoImpl implements AdminDao {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;


    public Admin findByNameAndPwd(Admin admin) {
        try{
            conn = JdbcUtil.getConnection();
            String sql = "select id from admin where name = ? and password = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, admin.getUserName());
            pstm.setString(2, admin.getPassword());
            rs = pstm.executeQuery();
            Admin ad = new Admin();
            if(rs.next()){
                ad.setId(rs.getInt(1));
                ad.setUserName(rs.getString(2));
                ad.setPassword(rs.getString(3));
            }
            return ad;
        }catch(Exception e){
            throw new RuntimeException();
        }finally{
            JdbcUtil.close(conn, pstm, rs);
        }
    }

    public void save(Admin admin) {
        try{
            conn = JdbcUtil.getConnection();
            String sql = "insert into admin(name, password) values(?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, admin.getUserName());
            pstm.setString(2,admin.getPassword());
            pstm.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException();
        }finally {
            JdbcUtil.close(conn, pstm, rs);
        }
    }

    public boolean userExists(String name) {
        try{
            String sql = "select id from admin where name = ?";
            conn = JdbcUtil.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                if (id > 0) {
                    // 用户名已经存在
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            throw new RuntimeException();
        }finally {
            JdbcUtil.close(conn, pstm, rs);
        }
    }
}
