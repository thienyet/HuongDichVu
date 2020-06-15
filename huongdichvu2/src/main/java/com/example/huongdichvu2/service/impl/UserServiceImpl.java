package com.example.huongdichvu2.service.impl;

import com.example.huongdichvu2.entity.Blog;
import com.example.huongdichvu2.entity.User;
import com.example.huongdichvu2.model.BlogDTO;
import com.example.huongdichvu2.model.UserDTO;
import com.example.huongdichvu2.repository.UserRepository;
import com.example.huongdichvu2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDTO userDTO) {
        User u = new User();
        u.setUsername(userDTO.getUsername());
        u.setPassword(userDTO.getPassword());
        u.setEmail(userDTO.getEmail());
        u.setRole(userDTO.getRole());
        userRepository.add(u);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        User u= userRepository.getById(userDTO.getId());
        if(u!=null) {
            userRepository.delete(u);
        }
    }

    @Override
    public List<UserDTO> getListUser() {
        List<UserDTO> listUserDTOs = new ArrayList<UserDTO>();
        List<User> listUser = userRepository.findAllUser();
        for(User user: listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setEmail(user.getEmail());
            userDTO.setRole(user.getRole());
            listUserDTOs.add(userDTO);
        }
        return listUserDTOs;
    }

    @Override
    public UserDTO getUserByID(int id) {
        UserDTO userDTO = new UserDTO();
        User user = userRepository.getById(id);
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
