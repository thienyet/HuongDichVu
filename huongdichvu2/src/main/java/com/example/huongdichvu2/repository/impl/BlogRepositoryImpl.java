package com.example.huongdichvu2.repository.impl;

import com.example.huongdichvu2.entity.Blog;
import com.example.huongdichvu2.repository.BlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Blog> findAllBlog() {
        try {
            String jpql = "SELECT blog FROM Blog blog";
            Query query = entityManager.createQuery(jpql);

            return query.getResultList();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public void add(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void delete(Blog blog) {
        entityManager.remove(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public Blog getById(int id) {
        try {
            String jpql = "SELECT blog FROM Blog blog WHERE blog.id LIKE :bid";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("bid", id);
            return (Blog)query.getSingleResult();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }
}
