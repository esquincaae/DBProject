package com.example.demo.services.interfaces;


import com.example.demo.controllers.dto.requests.CreateRolRequest;
import com.example.demo.controllers.dto.requests.UpdateRolRequest;
import com.example.demo.controllers.dto.responses.GetRolResponse;

import java.util.List;

public interface IRolService {

    GetRolResponse get(Long id);

    List<GetRolResponse> list();

    void delete(Long id);

    GetRolResponse create(CreateRolRequest request);

    GetRolResponse update(Long id, UpdateRolRequest request);
}
