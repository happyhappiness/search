package search.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import search.dao.BaseDAO;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


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

    // ����ID����ʵ��
    @SuppressWarnings("unchecked")
    public T get(Class<T> entityClazz, Serializable id) {
        return (T) getSessionFactory().getCurrentSession()
                .get(entityClazz, id);
    }

    // ����ʵ��
    public Serializable save(T entity) {
        return getSessionFactory().getCurrentSession()
                .save(entity);
    }

    // ����ʵ��
    public void update(T entity) {
        getSessionFactory().getCurrentSession().saveOrUpdate(entity);
    }

    // ɾ��ʵ��
    public void delete(T entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

    // ����IDɾ��ʵ��
    public void delete(Class<T> entityClazz, Serializable id) {
        getSessionFactory().getCurrentSession()
                .createQuery("delete " + entityClazz.getSimpleName()
                        + " en where en.id = ?")
                .setParameter("0", id)
                .executeUpdate();
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

 /*   @Override
    //�������ݿ⣬ɾ��������ɾ����Ϣ������ɾ��
    public boolean removeALLDeleted() {
        try {
            String className = getClass().getSimpleName();

            String queryString = "delete from " + className + " as model where model.isdeleted = 'Y'";
            Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
            query.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }*/


    // ����HQL����ѯʵ��
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql) {
        return (List<T>) getSessionFactory().getCurrentSession()
                .createQuery(hql)
                .list();
    }

    // ���ݴ�ռλ������HQL����ѯʵ��
    @SuppressWarnings("unchecked")
    protected List<T> find(String hql, Object... params) {
        // ������ѯ
        Query query = getSessionFactory().getCurrentSession()
                .createQuery(hql);
        // Ϊ����ռλ����HQL������ò���
        for (int i = 0, len = params.length; i < len; i++) {
            query.setParameter(i + "", params[i]);
        }
        return (List<T>) query.list();
    }

    /**
     * ʹ��hql �����з�ҳ��ѯ����
     *
     * @param hql      ��Ҫ��ѯ��hql���
     * @param pageNo   ��ѯ��pageNoҳ�ļ�¼
     * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
     * @return ��ǰҳ�����м�¼
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql,
                                 int pageNo, int pageSize) {
        // ������ѯ
        return getSessionFactory().getCurrentSession()
                .createQuery(hql)
                        // ִ�з�ҳ
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    /**
     * ʹ��hql �����з�ҳ��ѯ����
     *
     * @param hql      ��Ҫ��ѯ��hql���
     * @param params   ���hql��ռλ��������params���ڴ���ռλ������
     * @param pageNo   ��ѯ��pageNoҳ�ļ�¼
     * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
     * @return ��ǰҳ�����м�¼
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByPage(String hql, int pageNo, int pageSize
            , Object... params) {
        // ������ѯ
        Query query = getSessionFactory().getCurrentSession()
                .createQuery(hql);
        // Ϊ����ռλ����HQL������ò���
        for (int i = 0, len = params.length; i < len; i++) {
            query.setParameter(i + "", params[i]);
        }
        // ִ�з�ҳ�������ز�ѯ���
        return query.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    //����id��ȡ����
    public T findById(String id) {
        try {
            Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            T instance = (T) getSessionFactory().getCurrentSession().get(entityClass, id);

            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
/*
    //����ʵ��
    public List<T> findByExample(T instance) {

        Session session = getSessionFactory().getCurrentSession();
        List<T> results = session.createCriteria(getClass()).add(Example.create(instance)).list();

        return results;

    }*/
    
    
    //��������ֵ��ȡʵ���б�
    public List findByProperty(String propertyName, Object value) {
        String className = getClass().getSimpleName();

        String queryString = "from " + className + " as model where model."
                + propertyName + "= ?";
        Query query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setParameter(0, value);
        return query.list();
    }

    //���س־û�����
    public T merge(T detachedInstance) {

        T result = (T) getSessionFactory().getCurrentSession().merge(detachedInstance);

        return result;
    }

    //���� ����־û� better
    public void attachDirty(T instance) {
        getSessionFactory().getCurrentSession().saveOrUpdate(instance);
    }

    //����
    public void attachClean(T instance) {
        getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
    }
}

