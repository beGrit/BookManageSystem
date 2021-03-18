package org.pocky.demo.beans;

import lombok.Data;

import java.util.Date;

@Data
public class AdminUser {
    private Integer id;
    private String username;
    private String password;
    private Date lastLoginTime;
//    private Integer status;
//    private Integer is_deleted;
}
