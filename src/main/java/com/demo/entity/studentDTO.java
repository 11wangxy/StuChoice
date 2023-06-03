package com.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class studentDTO extends Student {
    private String action1;
    private String action2;
}
