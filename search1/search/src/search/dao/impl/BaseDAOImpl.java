package search.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import search.dao.BaseDAO;
import search.domain.Url;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;


@Repository
@Transactional
public class BaseDAOImpl<T> implements BaseDAO<T> {
    // DAO组件进行持久化操作底层依赖的SessionFactory组件
    @Resource
    private SessionFactory sessionFactory;

    // 依赖注入SessionFactory所需的setter方法
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }


    // 更新实体
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    // 删除实体
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    // 获取所有实体
    public List<T> findAll(Class<T> entityClazz) {
        return find("select en from "
                + entityClazz.getSimpleName() + " en");
    }
    
    // 获取实体总数
    public long findCount(Class<T> entityClazz) {
        List<?> l = find("select count(*) from "
                + entityClazz.getSimpleName());
        // 返回查询得到的实体总数
        if (l != null && l.size() == 1) {
            return (Long) l.get(0);
        }
        return 0;
    }

    // 根据HQL语句查询实体
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql) {
        return (List<T>) getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }

   

    //根据id获取对象
    public T findById(String id) {
        try {
            Class<T> entityClass = getEntityClass();
            T instance = (T) getSessionFactory().getCurrentSession().get(entityClass, id);

            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    private Class<T> getEntityClass(){
    	return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    //根据属性值获取实体列表
    public List findByProperty(String propertyName, Object value) {
    	
        String className = getEntityClass().getSimpleName();

        String queryString = "from " + className + " as model where model."
                + propertyName + "= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setParameter(0, value);
        return query.list();
    }

    //保存 对象持久化 better
    public void attachDirty(T instance) {
        getSessionFactory().getCurrentSession().saveOrUpdate(instance);
    }
}

