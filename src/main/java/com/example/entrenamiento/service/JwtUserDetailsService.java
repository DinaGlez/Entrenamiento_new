package com.example.entrenamiento.service;

import com.example.entrenamiento.model.JwtRequest;
import com.example.entrenamiento.repository.JwtRequestDAO;
import com.example.entrenamiento.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    JwtRequestDAO jwtRequestDAO;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    //TODO: cargar los datos como se indica en el ejercicio
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       /* Para load from file
       try {
            BufferedReader reader = Files.newBufferedReader(Paths.get("users.txt", String.valueOf(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        if (jwtRequestDAO.findJwtRequestByUsername(username).getUsername()!=null){
            JwtRequest temp=jwtRequestDAO.findJwtRequestByUsername(username);
            return new User(temp.getUsername(), temp.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("El usuario: " + username + "no fue encontrado");
        }
    }
    public String encode(String password) {

       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            String encodedPassword = passwordEncoder.encode(password);

            return encodedPassword;

    }

    public void insertUser (JwtRequest user){
       user.setPassword(encode(user.getPassword()));
        jwtRequestDAO.save(user);
    }
}