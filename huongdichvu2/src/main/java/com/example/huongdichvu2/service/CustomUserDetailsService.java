//package com.example.huongdichvu2.service;
//
//import com.example.huongdichvu2.entity.User;
//import com.example.huongdichvu2.model.UserDTO;
//import com.example.huongdichvu2.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        UserDTO userDTO = new UserDTO();
//        User user = userRepository.getByUsername(s);
//
//        userDTO.setId(user.getId());
//        userDTO.setUsername(user.getUsername());
//        userDTO.setPassword(user.getPassword());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setRole(user.getRole());
//
//        if(userDTO == null) {
//            System.out.println("User not found! " + s);
//            throw new UsernameNotFoundException("User " + s + " was not found in the database");
//        }
//
//        System.out.println("Found User: " + userDTO);
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (user.getRole() != null) {
//            authorities.add(new SimpleGrantedAuthority(user.getRole()));
//        }
//
//        UserDetails userDetails = (UserDetails) new User(user.getUsername(), //
//                user.getPassword(), authorities);
//
//        return userDetails;
//    }
//}
