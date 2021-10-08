package com.example.entrenamiento.repository;

import com.example.entrenamiento.model.Cliente;
import com.example.entrenamiento.model.Producto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteRepositoryTest {
    @Autowired
    private ClienteDAO clienteDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveClienteTest(){

        Cliente cliente = com.example.entrenamiento.model.Cliente.builder()
                .nombre("Dina")
                .apellido("Glez")
                .dni("12365478963")
                .email("dina@gmail.com")
                .telefono("3654789")
                .build();

        clienteDAO.save(cliente);

        Assertions.assertThat(cliente.getIdcliente()).isNotNull();
    }


    @Test
    @Order(2)
    public void getProductoTest(){

        Cliente cliente = clienteDAO.findById(1).get();

        Assertions.assertThat(cliente.getIdcliente()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void getAllProductosTest(){

        List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();

        Assertions.assertThat(clientes.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductoTest(){

        Cliente cliente = clienteDAO.findById(1).get();

        cliente.setNombre("Caja de Pollo");

        Cliente clienteUpdated =  clienteDAO.save(cliente);

        Assertions.assertThat(clienteUpdated.getNombre()).isEqualTo("Caja de Pollo");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteProductTest(){

        Cliente cliente = clienteDAO.findById(1).get();

        clienteDAO.delete(cliente);

        //employeeRepository.deleteById(1L);

        Cliente cliente1 = null;

        Optional<Cliente> optionalCliente = clienteDAO.findById(1);

        if(optionalCliente.isPresent()){
            cliente1 = optionalCliente.get();
        }

        Assertions.assertThat(cliente1).isNull();
    }

}

