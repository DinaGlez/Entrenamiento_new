package com.example.entrenamiento.service;

import com.example.entrenamiento.model.JwtRequest;
import com.example.entrenamiento.repository.JwtRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    JwtRequestDAO jwtRequestDAO;

    //TODO: cargar los datos como se indica en el ejercicio
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       // if ("javainuse".equals(username)) {
        if (jwtRequestDAO.findJwtRequestByUsername(username).getUsername()!=null){
            JwtRequest temp=jwtRequestDAO.findJwtRequestByUsername(username);
            // return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
            //        new ArrayList<>());
            return new User(temp.getUsername(), temp.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("El usuario: " + username + "no fue encontrado");
        }
    }
}