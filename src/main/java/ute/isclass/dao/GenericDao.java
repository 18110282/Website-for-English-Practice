package ute.isclass.dao;

import java.util.List;

public interface GenericDao<ID extends  Integer, T> {
    List<T> findAll();
    T update(T entity);
    T save(T entity);
    T findById(int var1);
    Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection);
    Integer deleteList(List<ID> ids);

}