package com.example.huongdichvu2.repository;

import com.example.huongdichvu2.entity.Blog;

import java.util.List;

public interface BlogRepository {

    public List<Blog> findAllBlog();
    public void add(Blog blog);
    public void delete(Blog blog);
    public void update(Blog blog);
    public Blog getById(int id);
}
