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
    // DAO������г־û������ײ�������SessionFactory���
    @Resource
    private SessionFactory sessionFactory;

    // ����ע��SessionFactory�����setter����
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }


    // ����ʵ��
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    // ɾ��ʵ��
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    // ��ȡ����ʵ��
    public List<T> findAll(Class<T> entityClazz) {
        return find("select en from "
                + entityClazz.getSimpleName() + " en");
    }
    
    // ��ȡʵ������
    public long findCount(Class<T> entityClazz) {
        List<?> l = find("select count(*) from "
                + entityClazz.getSimpleName());
        // ���ز�ѯ�õ���ʵ������
        if (l != null && l.size() == 1) {
            return (Long) l.get(0);
        }
        return 0;
    }

    // ����HQL����ѯʵ��
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql) {
        return (List<T>) getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }

   

    //����id��ȡ����
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
    
    //��������ֵ��ȡʵ���б�
    public List findByProperty(String propertyName, Object value) {
    	
        String className = getEntityClass().getSimpleName();

        String queryString = "from " + className + " as model where model."
                + propertyName + "= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setParameter(0, value);
        return query.list();
    }

    //���� ����־û� better
    public void attachDirty(T instance) {
        getSessionFactory().getCurrentSession().saveOrUpdate(instance);
    }
}

