package com.spring.jdbc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data //=> Will create getter, setter and toString() function
public class Customer {
    private String email;
    private String custname;
    private String city;
    private String phone;
    private String password;

}
