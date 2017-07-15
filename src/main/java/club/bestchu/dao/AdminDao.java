package club.bestchu.dao;

import club.bestchu.entity.Admin;

/**
 * Created by bestchu on 2017/7/14.
 */
public interface AdminDao {
    Admin findByNameAndPwd(Admin admin);

    void save(Admin admin);

    boolean userExists(String name);
}
