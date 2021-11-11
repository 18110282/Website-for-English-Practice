package ute.isclass.service_impl;

import ute.isclass.dao.AdminDao;
import ute.isclass.dao_impl.AdminDao_impl;
import ute.isclass.service.AdminService;

public class AdminService_impl implements AdminService {
    public AdminDao adminDao = new AdminDao_impl();
    public boolean checkAdminLogin(String username, String password)
    {
        return adminDao.checkAdminLogin(username, password);
    }
}
