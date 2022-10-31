package com.example.demo.services.interfaces;

import com.example.demo.controllers.dto.requests.CreateCarRequest;
import com.example.demo.controllers.dto.requests.UpdateCarRequest;
import com.example.demo.controllers.dto.responses.GetCarResponse;

import java.util.List;

public interface ICarService {

        GetCarResponse get(Long id);

        List<GetCarResponse> list();

        void delete(Long id);

        GetCarResponse create(CreateCarRequest request);

        GetCarResponse update(Long id, UpdateCarRequest request);

}
