package org.pocky.demo.service;

import org.junit.jupiter.api.Test;
import org.pocky.demo.dto.ResponseDto;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.exceptions.UpdateFailedException;
import org.pocky.demo.service.impl.AdminUserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserServiceTest {

    AdminUserService adminUserService = new AdminUserServiceImpl();


    @Test
    void queryById() {
    }

    @Test
    void testLogin() {
        try {
            ResponseDto responseDto = adminUserService.login("lsf", "LSFlsf123");
            System.out.println(responseDto);
        } catch (AuthenticationFailException e) {
            e.printStackTrace();
        } catch (UpdateFailedException e) {
            e.printStackTrace();
        }
    }
}