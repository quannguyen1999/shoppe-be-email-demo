package com.shopee.ecommer.shopeebeemaildemo.models.request;

import lombok.Data;

import java.util.List;

@Data
public class EmailDto {
    public List<String> toUsers;

    public List<String> ccUsers;

    public String subject;
}
