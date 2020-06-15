package com.example.huongdichvu2.service;


import com.example.huongdichvu2.model.UserDTO;

import java.util.List;

public interface UserService {

    public void createUser(UserDTO userDTO);
    public void deleteUser(UserDTO userDTO);
    public List<UserDTO> getListUser();
    public UserDTO getUserByID(int id);
}
