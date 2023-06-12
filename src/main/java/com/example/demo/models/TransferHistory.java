package com.example.demo.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document("TransferHistory")
@Data
@EqualsAndHashCode(callSuper = false)
public class TransferHistory  extends BaseModel{

    @Transient
    public static final String SEQUENCE_NAME = "transfer_sequence";

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal transferBalance;
    
}
