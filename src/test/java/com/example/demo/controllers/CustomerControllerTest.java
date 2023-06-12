package com.example.demo.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureDataMongo
@SpringBootTest
class CustomerControllerTest {

    @Autowired
    private CustomerController controller;

    @Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

    @Test
    void testCreateCustomer() {

    }

    @Test
    void testGetCustomer() {

    }

    @Test
    void testListCustomers() {

    }
}
