package org.pocky.demo.beans;

import lombok.Data;

import java.util.Date;

@Data
public class AdminUser {
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private Date lastLoginTime;
    private Date createTime;
    private Integer is_deleted;
}
