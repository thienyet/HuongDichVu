package com.example.huongdichvu2.service.impl;

import com.example.huongdichvu2.entity.Blog;
import com.example.huongdichvu2.model.BlogDTO;
import com.example.huongdichvu2.repository.BlogRepository;
import com.example.huongdichvu2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void createBlog(BlogDTO blogDTO) {
        Blog b = new Blog();
        b.setTitle(blogDTO.getTitle());
        blogRepository.add(b);
    }

    @Override
    public void deleteBlog(BlogDTO blogDTO) {
        Blog b = blogRepository.getById(blogDTO.getId());
        if(b!=null) {
            blogRepository.delete(b);
        }
    }

    @Override
    public List<BlogDTO> getListBlog() {
        List<BlogDTO> listBlogDTOs = new ArrayList<BlogDTO>();
        List<Blog> listBlog = blogRepository.findAllBlog();
        for(Blog blog: listBlog) {
            BlogDTO blogDTO = new BlogDTO();
            blogDTO.setTitle(blog.getTitle());
            listBlogDTOs.add(blogDTO);
        }
        return listBlogDTOs;
    }

    @Override
    public BlogDTO getBlogByID(int id) {
        BlogDTO blogDTO = new BlogDTO();
        Blog blog = blogRepository.getById(id);
        blogDTO.setId(blog.getId());
        blogDTO.setTitle(blog.getTitle());
        return blogDTO;
    }
}
