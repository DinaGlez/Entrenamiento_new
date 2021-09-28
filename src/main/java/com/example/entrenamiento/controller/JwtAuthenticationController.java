package com.example.entrenamiento.controller;
import com.example.entrenamiento.model.JwtRequest;
import com.example.entrenamiento.model.JwtResponse;
import com.example.entrenamiento.security.JwtTokenUtil;
import com.example.entrenamiento.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    //TODO: no usar wildcards ? en las respuestas.
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
    @PostMapping(value = "/user")
    public ResponseEntity<?> insertUser(@RequestBody JwtRequest datos)  {
        userDetailsService.insertUser(datos);
      return ResponseEntity.ok(datos);
    }

    //TODO:ok aunque este es un codigo legado de internet, seria bueno mejorar el manejo de excepciones creando propias.
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
            catch (BadCredentialsException e) {
              throw new Exception("Su usuario o su contraseña no son correctos", e);
            }

    }
}