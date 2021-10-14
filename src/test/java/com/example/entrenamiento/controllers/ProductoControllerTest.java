package com.example.entrenamiento.controllers;

import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.controller.ProductoController;
import com.example.entrenamiento.service.ProductoService;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;






//@WebMvcTest({ProductoController.class,JwtAuthenticationController.class})


public class ProductoControllerTest {

    @InjectMocks
    private ProductoController productoController;

    @Mock
    private ProductoService productoService;

    @Mock
    private ModelMapper modelMapper;


  /*  @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }*/

   @Autowired
   MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;


    ProductoDTO prod1=new ProductoDTO("ff1", 2.5,10);
    ProductoDTO prod2=new ProductoDTO("ff2", 2.5,10);
    ProductoDTO prod3=new ProductoDTO("ff3", 2.5,10);


   /* @Test
    public void getProductById(){
        Producto p = com.example.entrenamiento.model.Producto.builder()
                .nombre("Mayonesa")
                .idproducto(1)
                .precio(2.2)
                .build();

        when(productoService.getProductoById(1)).thenReturn(p);

        ProductoDTO productoDTO = productoController.getProductById(1);
        assertEquals(p.getNombre(),productoDTO.getNombre());
        }*/
}
