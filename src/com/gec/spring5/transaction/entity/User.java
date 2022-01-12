package com.gec.spring5.transaction.entity;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Setter
@Getter
@ToString
@Component(value = "User")
@AllArgsConstructor
@NoArgsConstructor
@Scope(value = "prototype")
public class User {
    @Nullable
    private  int id;
    private String name;
    private BigInteger money;

}
