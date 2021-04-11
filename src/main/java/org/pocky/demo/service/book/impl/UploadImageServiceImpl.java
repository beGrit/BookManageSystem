package org.pocky.demo.service.book.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.pocky.demo.exceptions.upload.UploadFailedException;
import org.pocky.demo.exceptions.upload.UploadFileTypeError;
import org.pocky.demo.handlers.FileUploadHandler;
import org.pocky.demo.handlers.ImageUploadHandler;
import org.pocky.demo.messages.FileUploadMessage;
import org.pocky.demo.service.book.UploadImageService;
import org.pocky.demo.factory.JsonSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadImageServiceImpl implements UploadImageService {
    FileUploadHandler handler = new ImageUploadHandler("/resource/images");

    @Override
    public void upload(HttpServletRequest req, HttpServletResponse resp) throws UploadFailedException {
        resp.setContentType("json");
        try {
            FileUploadMessage message = handler.uploadSingleFile(req, resp);
            if (message == null) {
                throw new UploadFailedException();
            } else {
                String json = JsonSerializer.serialize(200, "上传成功");
                resp.getWriter().write(json);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UploadFailedException e) {
            // 上传失败
            try {
                String json = JsonSerializer.serialize(500, "上传文件失败");
                resp.getWriter().write(json);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (UploadFileTypeError e) {
            // 表单不是多媒体类型
            try {
                String json = JsonSerializer.serialize(500, "表单不是多媒体类型", "error");
                resp.setContentType("json");
                resp.setCharacterEncoding("utf-8");
                resp.getWriter().write(json);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
