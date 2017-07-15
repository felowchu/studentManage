package club.bestchu.service;

import club.bestchu.entity.Admin;
import club.bestchu.exception.UserNotExistException;

/**
 * Created by bestchu on 2017/7/14.
 */
public interface Adminservice {
    void register(Admin admin) throws UserNotExistException;

    Admin login(Admin admin);
}
