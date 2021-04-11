package org.pocky.demo.service.book;

import org.pocky.demo.exceptions.upload.UploadFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UploadImageService {
    public void upload(HttpServletRequest req, HttpServletResponse resp) throws UploadFailedException;
}
