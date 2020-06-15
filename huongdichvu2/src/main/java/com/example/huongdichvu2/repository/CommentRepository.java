package com.example.huongdichvu2.repository;

import com.example.huongdichvu2.entity.Comment;

import java.util.List;

public interface CommentRepository {
    public List<Comment> findAllCommentByPost(int postId);
    public void add(Comment cmt);
    public void delete(Comment cmt);
    public void update(Comment cmt);
    public Comment getById(int id);
}
