package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.responses.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    BaseResponse upload(MultipartFile multipartFile);
}
