package org.pocky.demo.service.book.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.pocky.demo.dto.JsonResponse;
import org.pocky.demo.exceptions.upload.UploadFailedException;
import org.pocky.demo.exceptions.upload.UploadFileTypeError;
import org.pocky.demo.handlers.FileUploadHandler;
import org.pocky.demo.handlers.ImageUploadHandler;
import org.pocky.demo.messages.FileUploadMessage;
import org.pocky.demo.service.commons.UploadImageService;
import org.pocky.demo.factory.JsonSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadImageServiceImpl implements UploadImageService {
    FileUploadHandler handler = new ImageUploadHandler("/resources/images");

    @Override
    public void upload(HttpServletRequest req, HttpServletResponse resp) throws UploadFailedException, IOException {
        try {
            FileUploadMessage message = handler.uploadSingleFile(req, resp);
            if (message == null) {
                throw new UploadFailedException();
            } else {
                String json = JsonSerializer.serialize(200, "上传成功");
                // 写Json
                resp.getWriter().write(json);
            }
        } catch (UploadFailedException e) {

        } catch (UploadFileTypeError e) {

        }

    }

    public JsonResponse upload2(HttpServletRequest req, HttpServletResponse resp) throws UploadFailedException {
        return null;
    }
}
