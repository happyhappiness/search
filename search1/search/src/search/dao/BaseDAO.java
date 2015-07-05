package search.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDAO:����DAO�ӿ�
 */

@Repository
@Transactional
public interface BaseDAO<T>
{

    SessionFactory getSessionFactory();

    // ����ID����ʵ��
    T get(Class<T> entityClazz , Serializable id);
    // ����ʵ��
    Serializable save(T entity);
    // ����ʵ��
    void update(T entity);
    // ɾ��ʵ��
    void delete(T entity);
    // ����IDɾ��ʵ��
    void delete(Class<T> entityClazz , Serializable id);
    // ��ȡ����ʵ��
    List<T> findAll(Class<T> entityClazz);
    // ��ȡʵ������
    long findCount(Class<T> entityClazz);
/*
    boolean removeALLDeleted();
*/
    T findById(String id);
/*
    List findByExample(T instance);*/

    List findByProperty(String propertyName, Object value);

    T merge(T detachedInstance);

    void attachDirty(T instance);

    void attachClean(T instance);
}

