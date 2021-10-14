package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Producto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductoDAO productoDAO;
/*
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProductTest(){

        Producto producto = com.example.entrenamiento.model.Producto.builder()
                .nombre("Mayonesa")
               //.idproducto(10)
                .precio(2.2)
                .build();

        productoDAO.save(producto);

        Assertions.assertThat(producto.getIdproducto()).isNotNull();
    }


    @Test
    @Order(2)
    public void getProductoTest(){

        Producto producto = productoDAO.findById(1).get();

        Assertions.assertThat(producto.getIdproducto()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getAllProductosTest(){

        List<Producto> productos = (List<Producto>) productoDAO.findAll();

        Assertions.assertThat(productos.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductoTest(){

        Producto producto = productoDAO.findById(1).get();

        producto.setNombre("Caja de Pollo");

        Producto productoUpdated =  productoDAO.save(producto);

        Assertions.assertThat(productoUpdated.getNombre()).isEqualTo("Caja de Pollo");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteProductTest(){

        Producto producto = productoDAO.findById(1).get();

        productoDAO.delete(producto);


        Producto producto1 = null;

        Optional<Producto> optionalProducto = productoDAO.findById(1);

        if(optionalProducto.isPresent()){
            producto1 = optionalProducto.get();
        }

        Assertions.assertThat(producto1).isNull();
    }
*/
}
