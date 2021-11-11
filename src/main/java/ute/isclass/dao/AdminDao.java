package ute.isclass.dao;

import ute.isclass.entity.UserEntity;

public interface AdminDao extends GenericDao<Integer, UserEntity>{
    boolean checkAdminLogin(String username, String password);
}
