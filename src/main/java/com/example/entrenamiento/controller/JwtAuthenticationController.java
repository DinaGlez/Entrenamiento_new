package com.example.entrenamiento.controller;
//TODO: import no usado
import com.example.entrenamiento.model.JwtRequest;
import com.example.entrenamiento.model.JwtResponse;
import com.example.entrenamiento.security.JwtTokenUtil;
import com.example.entrenamiento.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

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
    //TODO: OK no usar requestmapping, usar los metodos que ya traen implicito el metodo HTTP, en este caso seria @PostMapping,
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    //TODO: aunque este es un codigo legado de internet, seria bueno mejorar el manejo de excepciones creando propias.
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } //catch (HttpClientErrorException e) {
             //  throw new Exception("USER_DISABLED", e);}
            catch (BadCredentialsException e) {
              throw new Exception("Su usuario o su contraseña no son correctos", e);
            }
            // catch (HttpClientErrorException.Unauthorized e) {
            //    throw new Exception("MUST PROVIDE AUTHENTICATION VALUES", e);
            // }
        //}
    }
}