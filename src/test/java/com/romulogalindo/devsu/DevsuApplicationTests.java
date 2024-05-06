package com.romulogalindo.devsu;

import com.romulogalindo.devsu.clientes.controllers.ClientesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DevsuApplicationTests {

    @Autowired
    private ClientesController controller;

    /*
    * Solo test de la existencia del controlador
    * */
    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
