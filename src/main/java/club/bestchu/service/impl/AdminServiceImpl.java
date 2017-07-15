package club.bestchu.service.impl;

import club.bestchu.dao.AdminDao;
import club.bestchu.dao.impl.AdminDaoImpl;
import club.bestchu.entity.Admin;
import club.bestchu.exception.UserNotExistException;
import club.bestchu.service.Adminservice;

/**
 * Created by bestchu on 2017/7/14.
 */
public class AdminServiceImpl implements Adminservice{
    private AdminDao adminDao = new AdminDaoImpl();

    public void register(Admin admin) throws UserNotExistException {
        try{
            boolean b = adminDao.userExists(admin.getUserName());

            if(b)
               throw new UserNotExistException("用化名以存在，注册失败");
            adminDao.save(admin);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Admin login(Admin admin){
        try{
            return adminDao.findByNameAndPwd(admin);
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}
