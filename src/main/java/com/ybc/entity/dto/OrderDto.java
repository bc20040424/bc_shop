package com.ybc.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class OrderDto implements Serializable {

    private String uid;
    private String oid;
    private Integer status;
}
