package com.javarush.khmelov.controller;

import com.javarush.khmelov.config.Winter;
import com.javarush.khmelov.service.ImageService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@WebServlet(value = "/images/*", name = "ImageServlet")
public class ImageServlet extends HttpServlet {

    private final ImageService imageService = Winter.getBean(ImageService.class);



    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String requestURI = req.getRequestURI();
        String target = req.getContextPath() + "/images/";
        String nameImage = requestURI.replace(target, "");
        Optional<Path> file = imageService.getImagePath(nameImage);
        if (file.isPresent()) {
            try (ServletOutputStream outputStream = resp.getOutputStream()) {
                Files.copy(file.get(), outputStream);
            }
        }
    }

}
