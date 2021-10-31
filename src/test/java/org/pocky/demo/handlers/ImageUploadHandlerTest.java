package org.pocky.demo.handlers;

import org.junit.jupiter.api.Test;
import org.pocky.demo.exceptions.upload.UploadFailedException;
import org.pocky.demo.messages.FileUploadMessage;
import org.pocky.demo.mock.RequestMock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImageUploadHandlerTest {

    ImageUploadHandler imageUploadHandler = new ImageUploadHandler("/resources/images");
    HttpServletRequest req = new RequestMock();
    HttpServletResponse resp;



    @Test
    void uploadSingleFile() throws UploadFailedException, IOException {
        FileUploadMessage message = imageUploadHandler.uploadSingleFile(req, resp);
    }
}