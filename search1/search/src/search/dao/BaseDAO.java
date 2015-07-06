package search.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDAO:基础DAO接口
 */

@Repository
@Transactional
public interface BaseDAO<T>
{

    SessionFactory getSessionFactory();

    // 删除实体
    void delete(T entity);
    
    // 获取所有实体
    List<T> findAll(Class<T> entityClazz);
    // 获取实体总数
    long findCount(Class<T> entityClazz);
    
    //使用hql语句查询 
	List<T> find(String hql);
	
    //获取基本属性相同的实体
	List<T> findByExample(T instance);
  
    List findByProperty(String propertyName, Object value);

    void attachDirty(T instance);



}

