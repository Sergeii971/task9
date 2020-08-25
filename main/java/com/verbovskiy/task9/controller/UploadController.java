package com.verbovskiy.task9.controller;

import com.verbovskiy.task9.reader.PyramidDataReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet( urlPatterns = {"/upload/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends HttpServlet {
    private static Logger logger = LogManager.getLogger(UploadController.class);

    private static final String UPLOAD_DIR = "uploads";

        @Override
        protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)
                throws ServletException, IOException {
            String applicationDir = request.getServletContext().getRealPath("");
            String uploadFileDir = applicationDir + File.separator + UPLOAD_DIR + File.separator;
            File fileSaveDir = new File(uploadFileDir);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdirs();
            }
            request.getParts().stream().forEach(part -> {
                try {
                    String path = part.getSubmittedFileName();
                    String randFilename = UUID.randomUUID()+path.substring(path.lastIndexOf("."));
                    part.write(uploadFileDir  + randFilename);
                    request.setAttribute("upload_result", " upload successfully ");
                } catch (IOException e) {
                    request.setAttribute("upload_result", " upload failed ");
                }
            });
            request.getRequestDispatcher("/jsp/upload_result.jsp").forward(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}

