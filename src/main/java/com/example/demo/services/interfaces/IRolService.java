package com.example.demo.services.interfaces;


import com.example.demo.controllers.dto.requests.RolRequest;
import com.example.demo.controllers.dto.responses.RolResponse;

import java.util.List;

public interface IRolService {

    RolResponse get(Long id);

    List<RolResponse> list();

    void delete(Long id);

    RolResponse create(RolRequest request);

    RolResponse update(Long id, RolRequest request);
}
