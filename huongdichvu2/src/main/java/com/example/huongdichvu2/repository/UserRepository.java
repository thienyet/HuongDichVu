package com.example.huongdichvu2.repository;

import com.example.huongdichvu2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository{

    public List<User> findAllByBlogRole(String role);
    public List<User> findAllUser();
    public void add(User user);
    public void delete(User user);
    public void update(User user);
    public User getById(int id);
    public User getByUsername(String username);
}
