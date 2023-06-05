package com.group20.coursemanagementsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.UUID;
import java.nio.file.Paths;
import java.nio.file.Files;

@Service
public class FileService {

    private static String fileDirectory = System.getProperty("user.dir").replace("backend", "frontend/public") + "/assets/";
    private static String imageDirectory = fileDirectory + "/images/";
    private static String videoDirectory = fileDirectory + "/videos/";
    private static String documentDirectory = fileDirectory + "/documents/";

    public String store(MultipartFile file, String email) {
        UUID uuid = UUID.randomUUID();
        String generatedFileName = email + "_" + uuid;
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        makeDirectoryIfNotExist(imageDirectory);
        Path storedFilePath = Paths.get(imageDirectory,
                generatedFileName.concat(".").concat(fileType));

        try {
            Files.write(storedFilePath, file.getBytes());
            String frontendPath = "/assets/images/" + generatedFileName.concat(".").concat(fileType);
            return frontendPath;
        } catch (IOException ex) {
            return ""; //TODO:
        }
    }

    private void makeDirectoryIfNotExist(String fileDir) {
        File directory = new File(fileDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

}

