package com.example.huongdichvu2.repository.impl;

import com.example.huongdichvu2.entity.User;
import com.example.huongdichvu2.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> findAllByBlogRole(String role) {
        try {
            String jpql = "SELECT user FROM User user WHERE user.role LIKE :role";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("role",  role );
            return query.getResultList();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public List<User> findAllUser() {
        try {
            String jpql = "SELECT user FROM User user";
            Query query = entityManager.createQuery(jpql);

            return query.getResultList();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        try {
            String jpql = "SELECT user FROM User user WHERE user.id LIKE :uid";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("uid", id);
            return (User)query.getSingleResult();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public User getByUsername(String username) {
        try {
            String jpql = "SELECT user FROM User user WHERE user.username LIKE :username";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("username", username);
            return (User)query.getSingleResult();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }
}
