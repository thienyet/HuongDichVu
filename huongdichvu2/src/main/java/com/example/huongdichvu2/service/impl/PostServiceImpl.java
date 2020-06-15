package com.example.huongdichvu2.service.impl;

import com.example.huongdichvu2.entity.Blog;
import com.example.huongdichvu2.entity.Post;
import com.example.huongdichvu2.model.BlogDTO;
import com.example.huongdichvu2.model.PostDTO;
import com.example.huongdichvu2.repository.PostRepository;
import com.example.huongdichvu2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(PostDTO postDTO) {
        Post p = new Post();
        p.setCreateDate(postDTO.getCreateDate());
        p.setTitle(postDTO.getTitle());
        p.setThumbnail(postDTO.getThumbnail());
        p.setDescription(postDTO.getDescription());
        p.setContent(postDTO.getContent());
        p.setAuthor(postDTO.getAuthor());
        p.setBlogId(postDTO.getBlogId());
        postRepository.add(p);
    }

    @Override
    public void deletePost(PostDTO postDTO) {
        Post p = postRepository.getById(postDTO.getId());
        if(p!=null) {
            postRepository.delete(p);
        }
    }

    @Override
    public List<PostDTO> getListPost() {
        List<PostDTO> listPostDTOs = new ArrayList<PostDTO>();
        List<Post> listPost = postRepository.findAllPost();
        for(Post post: listPost) {
            PostDTO postDTO = new PostDTO();
            postDTO.setCreateDate(post.getCreateDate());
            postDTO.setTitle(post.getTitle());
            postDTO.setThumbnail(post.getThumbnail());
            postDTO.setDescription(post.getDescription());
            postDTO.setContent(post.getContent());
            postDTO.setAuthor(post.getAuthor());
            postDTO.setBlogId(post.getBlogId());
            listPostDTOs.add(postDTO);
        }
        return listPostDTOs;
    }

    @Override
    public List<PostDTO> getListPostByBlogId(int blogId) {
        List<PostDTO> listPostDTOs = new ArrayList<PostDTO>();
        List<Post> listPostById = postRepository.findAllByBlogId(blogId);
        for(Post post: listPostById) {
            PostDTO postDTO = new PostDTO();
            postDTO.setCreateDate(post.getCreateDate());
            postDTO.setTitle(post.getTitle());
            postDTO.setThumbnail(post.getThumbnail());
            postDTO.setDescription(post.getDescription());
            postDTO.setContent(post.getContent());
            postDTO.setAuthor(post.getAuthor());
            postDTO.setBlogId(post.getBlogId());
            listPostDTOs.add(postDTO);
        }
        return listPostDTOs;
    }

    @Override
    public PostDTO getPostByID(int id) {
        PostDTO postDTO = new PostDTO();
        Post post = postRepository.getById(id);
        postDTO.setId(post.getId());
        postDTO.setCreateDate(post.getCreateDate());
        postDTO.setTitle(post.getTitle());
        postDTO.setThumbnail(post.getThumbnail());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        postDTO.setAuthor(post.getAuthor());
        postDTO.setBlogId(post.getBlogId());
        return postDTO;
    }
}
