package ute.isclass.test;

import org.testng.annotations.Test;
import ute.isclass.dao.AdminDao;
import ute.isclass.dao_impl.AdminDao_Impl;

public class AdminTest {
    @Test
    public void CheckAdminLogin() {
        String username = "hieuxt";
        String password = "1";
        boolean a = false;
        AdminDao adminDao = new AdminDao_Impl();
        a = adminDao.checkAdminLogin(username, password);
        System.out.println(a);
    }
}
