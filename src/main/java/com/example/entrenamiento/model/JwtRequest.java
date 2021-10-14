package com.example.entrenamiento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor


public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;
    private Integer id;
    private String username;
    private String password;

}