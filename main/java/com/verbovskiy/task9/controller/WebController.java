package com.verbovskiy.task9.controller;

import com.verbovskiy.task9.reader.PyramidDataReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/WebController")
public class WebController extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String applicationDir = request.getServletContext().getRealPath("");
        String path = applicationDir + File.separator + UPLOAD_DIR + File.separator;
        File fileSaveDir = new File(path);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        File directory = new File(path);
        File[] files = directory.listFiles();
        File lastModified = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModified.lastModified() < files[i].lastModified()) {
                lastModified = files[i];
            }
        }
        PyramidDataReader reader = new PyramidDataReader();
        String lastModifiedName = lastModified.getAbsolutePath();
        List<String> list = reader.readFileData(lastModifiedName);
        String result = String.join("\n", list);
        request.setAttribute("file_content", result);
        request.getRequestDispatcher("/jsp/file_view.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
