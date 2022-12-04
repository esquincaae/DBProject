package com.example.demo.services.interfaces;


import com.example.demo.controllers.dto.requests.RolRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.controllers.dto.responses.RolResponse;

import java.util.List;

public interface IRolService {

    BaseResponse get(Long id);

    BaseResponse list();

    BaseResponse delete(Long id);

    BaseResponse create(RolRequest request);

    BaseResponse update(Long id, RolRequest request);
}
