package com.example.huongdichvu2.repository;

import com.example.huongdichvu2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {

    public List<Post> findAllByBlogId(int blogId);
    public List<Post> findAllPost();
    public void add(Post post);
    public void delete(Post post);
    public void update(Post post);
    public Post getById(int id);
}
//extends JpaRepository<Post, Integer>