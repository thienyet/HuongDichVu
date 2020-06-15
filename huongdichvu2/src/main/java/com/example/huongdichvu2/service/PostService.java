package com.example.huongdichvu2.service;

import com.example.huongdichvu2.model.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public void createPost(PostDTO postDTO);
    public void deletePost(PostDTO postDTO);
    public List<PostDTO> getListPost();
    public List<PostDTO> getListPostByBlogId(int blogId);
    public PostDTO getPostByID(int id);
}
