package org.pocky.demo.service.commons;

import org.pocky.demo.exceptions.upload.UploadFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UploadImageService {
    /**
     *
     * @param req
     * @param resp
     * @throws UploadFailedException 文件上传失败
     * @throws IOException 写入resp域失败
     */
    public void upload(HttpServletRequest req, HttpServletResponse resp) throws UploadFailedException, IOException;
}
