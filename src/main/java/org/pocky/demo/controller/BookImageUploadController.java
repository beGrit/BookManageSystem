package org.pocky.demo.controller;

import org.pocky.demo.service.book.UploadImageService;
import org.pocky.demo.service.book.impl.UploadImageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UploadController", urlPatterns = {"/admin/book/image"})
public class BookImageUploadController extends BaseController {
    UploadImageService uploadImageService = new UploadImageServiceImpl();

    public void uploadSingleImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            uploadImageService.upload(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("/WEB-INF/views/commons/500.jsp").forward(req, resp);
        }
    }
}
