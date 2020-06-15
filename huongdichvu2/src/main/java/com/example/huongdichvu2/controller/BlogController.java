package com.example.huongdichvu2.controller;

import com.example.huongdichvu2.model.BlogDTO;
import com.example.huongdichvu2.model.PostDTO;
import com.example.huongdichvu2.service.BlogService;
import com.example.huongdichvu2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/tintuc")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private PostService postService;

    @GetMapping("/trangchu")
    public String getTrangChu(Model model) {
        List<BlogDTO> listBlog = blogService.getListBlog();
        model.addAttribute("list", listBlog);
        return "listBlogs";
    }


    @GetMapping("/danhmuc")
    public String getThoiSu(@RequestParam(name="blogId",required = false) String id, Model model) {

        BlogDTO blogDTO = blogService.getBlogByID(Integer.parseInt(id));
        model.addAttribute("blog", blogDTO);

        List<PostDTO> listPostOfBlog = postService.getListPostByBlogId(Integer.parseInt(id));
        model.addAttribute("list", listPostOfBlog);
        return "category";
    }

//    @GetMapping("/thegioi")
//    public String getThegioi(@RequestParam(name="blogId",required = false) String id, Model model) {
//
//        BlogDTO blogDTO = blogService.getBlogByID(Integer.parseInt(id));
//        model.addAttribute("blog", blogDTO);
//
//        List<PostDTO> listPostOfBlog = postService.getListPostByBlogId(Integer.parseInt(id));
//        model.addAttribute("list", listPostOfBlog);
//        return "listBlogs";
//    }

}
