package me.alexksysx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageUploadController {

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);
    private String imageDirectory;

    public ImageUploadController(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadImage(@RequestParam MultipartFile file) throws IOException {
        String hash = DigestUtils.md5DigestAsHex(file.getBytes());
        logger.info("File was uploaded: " + hash);
        File localFile = new File(imageDirectory + hash);
        file.transferTo(localFile);
        return ResponseEntity.ok().build();
    }
}
