package com.example.huongdichvu2.service;


import com.example.huongdichvu2.model.CommentDTO;

import java.util.List;

public interface CommentService {

    public void createComment(CommentDTO userDTO);
    public void deleteComment(CommentDTO userDTO);
    public List<CommentDTO> getListCommentByPost(int postId);
    public CommentDTO getCommentByID(int id);
}
