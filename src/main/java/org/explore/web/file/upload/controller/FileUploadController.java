package org.explore.web.file.upload.controller;

import org.explore.web.file.upload.util.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author neil
 * @email lirui10093622@163.com
 * @time 2018-12-24 16:42:03
 */
@RestController
@RequestMapping("api/file")
public class FileUploadController {

    @RequestMapping(value = "upload")
    public String upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part part = request.getPart("uploadFileName");
        FileUtil.write(part.getInputStream(), getFilePath(part.getSubmittedFileName()));
        return "success";
    }

    private String getFilePath(String fileName) {
        return "/tmp/" + fileName;
    }
}