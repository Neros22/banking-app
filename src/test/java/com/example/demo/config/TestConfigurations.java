package com.example.demo.config;

import com.example.demo.services.CustomerService;
import com.example.demo.services.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class TestConfigurations{

    @Autowired
    CustomerService customerService;

    @Autowired
    SequenceGeneratorService generatorService;
}