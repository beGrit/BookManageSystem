package org.pocky.demo.handlers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.pocky.demo.exceptions.upload.UploadFailedException;
import org.pocky.demo.exceptions.upload.UploadFileTypeError;
import org.pocky.demo.messages.FileUploadMessage;
import org.pocky.demo.factory.JsonSerializer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ImageUploadHandler extends FileUploadHandler {

    public ImageUploadHandler(String dirPath) {
        this.allowedSuffixes = new String[]{
                "png", "bmp", "jpeg"
        };
        // 规定 dirPath 只能是 [ 1,10 ]个字符长度,且只能包含字母
        if (dirPath == null || dirPath.equals("") || dirPath.length() > 10) {

        } else {
            String pattern = "";
            dirPath.matches("");
        }
        this.dirPath = dirPath;
    }


    public boolean checkRequest(HttpServletRequest req) {
        return false;
    }

    /**
     * 从表单请求中提取文件并上传到服务器
     *
     * @param req
     * @param resp
     * @return true: upload success, false: upload failed
     * @throws IOException
     */
    @Override
    public FileUploadMessage uploadSingleFile(HttpServletRequest req, HttpServletResponse resp) throws IOException, UploadFailedException, UploadFileTypeError {
        if (!ServletFileUpload.isMultipartContent(req)) {
            // 校验请求表单的Type是多媒体类型
            throw new UploadFileTypeError("Error: 表单必须包含 enctype=multipart/form-data");
        }
        // 创建 + 配置 factory 和 upload 对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(MAX_FILE_SIZE);
        upload.setHeaderEncoding("UTF-8");
        FileItem t = null;
        try {
            String realUploadDirPath = req.getServletContext().getRealPath("/") + File.separator + this.dirPath;
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    String name = fileItem.getName();
                    String suffix = name.substring(name.lastIndexOf(".") + 1);
                    // 校验文件后缀的正确性
                    boolean isAllowed = false;
                    for (String s : this.allowedSuffixes) {
                        if (suffix.equals(s)) {
                            isAllowed = true;
                            break;
                        }
                    }
                    if (!isAllowed) {
                        // 抛出文件类型错误异常
                        throw new UploadFileTypeError("Error: 文件类型错误: " + suffix);
                    } else {
                        // 创建文件
                        File uploadDir = new File(realUploadDirPath);
                        if (!uploadDir.exists()) {
                            uploadDir.mkdir();
                        }
                        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
                        File file = new File(realUploadDirPath + File.separator + fileName);
                        fileItem.write(file);
                        return new FileUploadMessage();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            throw new UploadFailedException();
        } catch (Exception e) {
            throw new UploadFailedException();
        }
        return null;
    }
}
