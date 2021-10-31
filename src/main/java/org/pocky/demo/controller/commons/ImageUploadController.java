package org.pocky.demo.controller.commons;

import org.pocky.demo.controller.BaseController;
import org.pocky.demo.exceptions.upload.UploadFailedException;
import org.pocky.demo.service.book.impl.UploadImageServiceImpl;
import org.pocky.demo.service.commons.UploadImageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/upload"})
public class ImageUploadController extends BaseController {
    UploadImageService uploadImageService = new UploadImageServiceImpl();

    public void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            uploadImageService.upload(req, resp);
        } catch (UploadFailedException | IOException e) {
            throw new ServletException("服务器异常 请联系管理员");
        }
    }
}
