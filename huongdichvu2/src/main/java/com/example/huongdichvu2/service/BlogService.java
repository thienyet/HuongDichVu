package com.example.huongdichvu2.service;

import com.example.huongdichvu2.model.BlogDTO;

import java.util.List;

public interface BlogService {

    public void createBlog(BlogDTO blogDTO);
    public void deleteBlog(BlogDTO blogDTO);
    public List<BlogDTO> getListBlog();
    public BlogDTO getBlogByID(int id);
}
