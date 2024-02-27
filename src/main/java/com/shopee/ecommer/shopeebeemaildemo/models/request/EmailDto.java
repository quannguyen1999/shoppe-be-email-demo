package com.shopee.ecommer.shopeebeemaildemo.models.request;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class EmailDto {
    public List<String> emailsFrom;

    public List<String> emailsTo;

    public String content;

    public String subject;
}
