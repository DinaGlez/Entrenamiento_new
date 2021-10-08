package com.example.entrenamiento.controllers;

import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.controller.ProductoController;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.ProductoDAO;
import com.example.entrenamiento.service.ProductoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)

//@SpringApplicationConfiguration()

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    ProductoService productoService;

    ProductoDTO prod1=new ProductoDTO("ff1", 2.5,10);
    ProductoDTO prod2=new ProductoDTO("ff2", 2.5,10);
    ProductoDTO prod3=new ProductoDTO("ff3", 2.5,10);

    @Test
    public void getAll_success() throws IOException {
       /* List<ProductoDTO> productos = new ArrayList<>(Arrays.asList(prod1,prod2,prod3));

        Mockito.when(productoService.getProductos()).thenReturn(productos);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("Mantequilla")));*/
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/products", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), equalTo("[3]"));

    }
}
