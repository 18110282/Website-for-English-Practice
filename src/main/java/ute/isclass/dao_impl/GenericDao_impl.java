package ute.isclass.dao_impl;

import ute.isclass.dao.GenericDao;
import ute.isclass.utils.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class GenericDao_impl<ID extends Integer,T> implements GenericDao<ID,T> {
    protected final Class<T> persistenceClass;
    public GenericDao_impl(){
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }


    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        try{

            String getTable = this.getPersistenceClassName();
            String hql = "from " + getTable;
            Query query = session.createQuery(hql);
            list = query.list();
            transaction.commit();
            session.clear();
        }
        catch (HibernateException e){
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        T result  = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try{
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        }
        catch(HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }

    public T save(T entity) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try{
            session. persist(entity);
            transaction.commit();
        }
        catch(HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return entity;
    }


    public T findById(int var1) {
        T result = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try{
            result = (T) session.get(persistenceClass, var1);
            if(result == null){
                throw new ObjectNotFoundException("Not found "+ var1, null);
            }
            transaction.commit();
        }
        catch(HibernateException e)
        {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return result;
    }

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T> list = new ArrayList<T>();
        Object totalItem = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        try
        {
            StringBuilder sql1 = new StringBuilder("from ");
            sql1.append(getPersistenceClassName());
            if(property != null && value != null) {
                sql1.append(" where ").append(property).append("= :value");
            }
            if(sortExpression != null && sortDirection != null){
                sql1.append(" order by ").append(sortExpression);
                sql1.append(" " + (sortDirection.equals("ASC")?"ASC":"DESC"));
            }
            Query query1 = session.createQuery(sql1.toString());
            query1.setParameter("value", value);
            list = query1.list();

            StringBuilder sql2 = new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName());
            if(property != null && value != null) {
                sql2.append(" where ").append(property).append("= :value");
                Query query2 = session.createQuery(sql2.toString());
                query2.setParameter("value", value);
                totalItem = query2.list().get(0);
            }
            //totalItem = query2.list().get(0);

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
        return new Object[]{totalItem, list};
    }

    public Integer deleteList(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        try{
            for(ID item: ids){
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                count++;
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
        return count;
    }
}
