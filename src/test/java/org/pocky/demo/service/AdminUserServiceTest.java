package org.pocky.demo.service;

import org.junit.jupiter.api.Test;
import org.pocky.demo.dto.JsonResponse;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.exceptions.UpdateFailedException;
import org.pocky.demo.service.admin.AdminUserService;
import org.pocky.demo.service.admin.impl.AdminUserServiceImpl;

class AdminUserServiceTest {

    AdminUserService adminUserService = new AdminUserServiceImpl();


    @Test
    void queryById() {
    }

    @Test
    void testLogin() {
        try {
            JsonResponse jsonResponse = adminUserService.login("lsf", "LSFlsf123");
            System.out.println(jsonResponse);
        } catch (AuthenticationFailException e) {
            e.printStackTrace();
        } catch (UpdateFailedException e) {
            e.printStackTrace();
        }
    }
}