package com.example.huongdichvu2.repository.impl;

import com.example.huongdichvu2.entity.Comment;
import com.example.huongdichvu2.entity.User;
import com.example.huongdichvu2.repository.CommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comment> findAllCommentByPost(int postId) {
        try {
            String jpql = "SELECT cmt FROM Comment cmt WHERE cmt.postId LIKE :pid";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("pid",  postId );
            return query.getResultList();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }

    @Override
    public void add(Comment cmt) {
        entityManager.persist(cmt);
    }

    @Override
    public void delete(Comment cmt) {
        entityManager.remove(cmt);
    }

    @Override
    public void update(Comment cmt) {
        entityManager.merge(cmt);
    }

    @Override
    public Comment getById(int id) {
        try {
            String jpql = "SELECT cmt FROM Comment cmt WHERE cmt.id LIKE :cid";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("cid", id);
            return (Comment) query.getSingleResult();
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e);
            return null;
        }
    }
}
