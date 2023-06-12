package com.example.demo.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public abstract class BaseModel {

    @Id
    private Long id;

    private Date created;

    private Date updated;

    private boolean statusActive;

}
