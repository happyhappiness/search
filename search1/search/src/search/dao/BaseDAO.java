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

    // ɾ��ʵ��
    void delete(T entity);
    
    // ��ȡ����ʵ��
    List<T> findAll(Class<T> entityClazz);
    // ��ȡʵ������
    long findCount(Class<T> entityClazz);
    
    //ʹ��hql����ѯ 
	List<T> find(String hql);
	
    //��ȡ����������ͬ��ʵ��
	List<T> findByExample(T instance);
  
    List findByProperty(String propertyName, Object value);

    void attachDirty(T instance);



}

