package org.pocky.demo.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TestController", value = "/test")
public class TestController extends BaseController {
    public void test(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println();
    }
}
