package ute.isclass.dao_impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ute.isclass.dao.AdminDao;
import ute.isclass.entity.UserEntity;
import ute.isclass.utils.HibernateUtil;

public class AdminDao_Impl extends GenericDao_Impl<Integer, UserEntity> implements AdminDao{

    public boolean checkAdminLogin(String username, String password) {
        boolean exist = false;
        Object a = new Object();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        try{
            StringBuilder sql = new StringBuilder("select count(*) from UserEntity U ");
            sql.append("where U.username = :value1");
            sql.append(" and U.password = :value2");
            sql.append(" and U.roleEntity.roleID = :value3");
            Query query = session.createQuery(sql.toString());
            query.setParameter("value1", username);
            query.setParameter("value2", password);
            query.setParameter("value3", 1);
            a = query.list().get(0);
            int c =  Integer.parseInt((a).toString());
            if(c == 1)
            {
                exist = true;
            }
            transaction.commit();
        }
        catch (HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return exist;
    }
}
