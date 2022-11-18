package com.example.demo.services;

import com.example.demo.controllers.dto.requests.CreateCarProductRequest;
import com.example.demo.controllers.dto.requests.UpdateCarProductRequest;
import com.example.demo.controllers.dto.responses.GetCarProductResponse;
import com.example.demo.controllers.dto.responses.GetUserResponse;
import com.example.demo.entities.Product;
import com.example.demo.entities.pivots.CarProduct;
import com.example.demo.repositories.ICarProductRepository;
import com.example.demo.repositories.ICarRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.interfaces.ICarProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarProductService implements ICarProductService{
    @Autowired
    private ICarProductRepository repository;
    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public GetCarProductResponse get(Long id){ return from(id); }

    @Override
    public List<GetCarProductResponse> list(){
        List<GetCarProductResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public GetCarProductResponse create(CreateCarProductRequest request){
        CarProduct carProduct = new CarProduct();
        carProduct.setProductId(request.getProductId());
        carProduct.setCarId(request.getCarId());
        Optional<Product> product = ProductRepository.findById(request.getProductId());
        carProduct.setProductId(product.get());
        return from(repository.save(carProduct));
    }

    @Override
    public GetCarProductResponse update(Long id, UpdateCarProductRequest request){
        CarProduct carProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("El carrito no existe"));
        carProduct = update(carProduct, request);
        return from(carProduct);
    }

    private CarProduct from(CreateCarProductRequest request){
        CarProduct carProduct = new CarProduct();
        carProduct.setProductId(request.getProductId());
        carProduct.setCarId(request.getCarId());
        return carProduct;
    }

    private GetCarProductResponse from(CarProduct carProduct){
        GetCarProductResponse response = new GetCarProductResponse();
        response.setId(carProduct.getId());
        response.setProductId(carProduct.getProductId().getId());
        response.setCantProd(carProduct.getCantProd());
        response.setCarId(carProduct.getCarId().getId());
        return response;
    }

    private GetUserResponse from(Long idCarProduct){
        return repository
                .findById(idCarProduct)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El carrito no existe"));
    }

}
