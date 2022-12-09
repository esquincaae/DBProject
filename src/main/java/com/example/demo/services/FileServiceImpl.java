package com.example.demo.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.services.interfaces.IFileService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class FileServiceImpl implements IFileService {
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dmwn1o14i",
            "api_key", "892637196132421",
            "api_secret", "s08xvfEC4E93x5sjISdB5Lonx5U"));

    private final Map<String, String> cloudinaryConfig = new HashMap<>();

    @Override
    public BaseResponse upload(MultipartFile multipartFile) {
        String fileUrl = "";

        try {
            File file = convertMultipartFileToFile(multipartFile);

            String fileName = generateFileName(multipartFile);

            fileUrl = uploadFileToCloudinary(fileName, file);

            file.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> message = new HashMap<>();
        message.put("url", fileUrl);


        return BaseResponse.builder()
                .data(message)
                .message("Image uploaded")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    public File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }

    public String generateFileName(MultipartFile multipartFile) {
        Date date = new Date();
        String filename = (date + "-" + multipartFile.getOriginalFilename()).replace(" ", "_");

        return removeExtensionFromFilename(filename);
    }

    public String removeExtensionFromFilename(String filename) {
        if (filename.indexOf(".") > 0)
            return filename.substring(0, filename.lastIndexOf("."));
        return filename;
    }

    private String uploadFileToCloudinary(String fileName, File file) throws IOException {
        cloudinaryConfig.put("public_id", fileName);
        Map response = cloudinary.uploader().upload(file, cloudinaryConfig);

        return (String) response.get("url");
    }
}