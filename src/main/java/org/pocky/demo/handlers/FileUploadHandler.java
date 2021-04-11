package org.pocky.demo.handlers;

import lombok.Data;
import org.pocky.demo.exceptions.upload.UploadFailedException;
import org.pocky.demo.exceptions.upload.UploadFileTypeError;
import org.pocky.demo.messages.FileUploadMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FileUploadHandler {
    // 上传限制配置
    protected String dirPath;
    protected String[] allowedSuffixes;

    // 上传配置
    protected static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    protected static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    protected static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public String[] getAllowedSuffixes() {
        return allowedSuffixes;
    }

    public void setAllowedSuffixes(String[] allowedSuffixes) {
        this.allowedSuffixes = allowedSuffixes;
    }

    public abstract FileUploadMessage uploadSingleFile(HttpServletRequest req, HttpServletResponse resp) throws IOException, UploadFailedException, UploadFileTypeError;
}
