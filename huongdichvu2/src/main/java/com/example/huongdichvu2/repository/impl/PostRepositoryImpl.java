package com.example.huongdichvu2.repository.impl;

import com.example.huongdichvu2.entity.Blog;
import com.example.huongdichvu2.entity.Post;
import com.example.huongdichvu2.repository.PostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PostRepositoryImpl implements PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Post> findAllByBlogId(int blogId) {
        try {
            String jpql = "SELECT post FROM Post post WHERE post.blogId LIKE :bid";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("bid",  blogId );
            return query.getResultList();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public List<Post> findAllPost() {
        try {
            String jpql = "SELECT post FROM Post post";
            Query query = entityManager.createQuery(jpql);

            return query.getResultList();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public void add(Post post) {
        entityManager.persist(post);
    }

    @Override
    public void delete(Post post) {
        entityManager.remove(post);
    }

    @Override
    public void update(Post post) {
        entityManager.merge(post);
    }

    @Override
    public Post getById(int id) {
        try {
            String jpql = "SELECT post FROM Post post WHERE post.id LIKE :pid";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("pid", id);
            return (Post)query.getSingleResult();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }
}
