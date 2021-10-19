package com.example.entrenamiento.services;



import com.example.entrenamiento.DTO.ProductoDTO;
import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.ProductoDAO;


import com.example.entrenamiento.service.Impl.ProductoServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)

public class ProductoServicioTest {


    @Mock
    private ProductoDAO productoDAO;

    @Mock
    private ModelMapper modelMapper;
    @Mock
    private ProductoDTO productoDTO;
    @Autowired
    @InjectMocks
    private ProductoServiceImpl productoService;
    private Producto product1;
    private Producto product2;
    private ProductoDTO productDTO1;
    private ProductoDTO productDTO2;

    List<Producto> productList;
    List<ProductoDTO> productDTOList;
    @BeforeEach
    public void setUp() {
        //when(modelMapper.map(any(),ProductoDTO.class)).thenReturn(productDTO1);

        productList = new ArrayList<>();
        productDTOList = new ArrayList<>();
        product1 = new Producto(1, "bread",2.2,20);
        product1.setIdproducto(1);
        product1.setNombre("butter");
        product1.setCantidad(100);
        product2 = new Producto(2, "jam",2.2,200);
        productDTO1= new ProductoDTO("bread",2.2,20);
        productoDTO.setNombre("butter");
        productDTO2= new ProductoDTO("jam",2.2,200);
        productList.add(product1);
        productList.add(product2);
        productDTOList.add(productDTO1);
      //  productDTOList.add(productDTO2);
    }
    @AfterEach
    public void tearDown() {
        product1 = product2 = null;
        productDTO1 = productDTO2 = null;

        productList = null;
        productDTOList = null;

    }
/*
    @Test
    public void getProductById(){
        when(productoDAO.findById(1)).thenReturn(Optional.of(product1));

        Producto producto = productoService.getProductoById(1);
        assertThat(producto.getIdproducto(),is(1));
        }

    @Test
    public void getProductById2()
    {
        when(productoDAO.findById(1)).thenReturn(Optional.of(product2));

        Producto prod = productoService.getProductoById(1);

        assertEquals("jam", prod.getNombre());
        assertEquals(200, prod.getCantidad());
        assertEquals(2.2, prod.getPrecio());
    }

    @Test
    void AddProduct() {

        when(productoDAO.save(any())).thenReturn(product1);
         productoService.AddProducto(productDTO1);
        verify(productoDAO,times(1)).save(any());
        assertThat(productoDAO.findById(1),is(notNullValue()));
      //  assertThat(productoDAO.findById(1).orElse(null).getNombre(),is("butter"));
    }
    @Test
    public void GetAllProducts(){

        when(productoDAO.findAll()).thenReturn(productList);
        when(modelMapper.map(any(),ProductoDTO.class)).thenReturn(productDTO1);

        List<ProductoDTO> productList1 =productoService.getProductos();
        assertThat(productList1.size(), is(1));
    }
    @Test
    public void DeleteProduct() throws Exception {
        when(productoDAO.save(any())).thenReturn(product1);
        productoService.AddProducto(productDTO1);
        productoService.deleteProducto(1);
        assertThat(productoDAO.findById(1),is(Optional.empty()));

    }
    @Test
    public void UpdateProducto(){
        when(productoDAO.save(product1)).thenReturn(product1);
        productoService.updateProducto(1,productoDTO);
        assertThat(productoDAO.findById(1),is(product1));

    }*/
}

