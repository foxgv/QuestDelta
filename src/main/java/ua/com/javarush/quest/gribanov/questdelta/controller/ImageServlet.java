package ua.com.javarush.quest.gribanov.questdelta.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.List.of;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String requestURI = req.getRequestURI();
        String target = req.getContextPath() + "/images/";
        String nameImage = requestURI.replace(target, "");
        Path file = Paths.get(requestURI);
        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            Files.copy(file, outputStream);
        }
    }

}
