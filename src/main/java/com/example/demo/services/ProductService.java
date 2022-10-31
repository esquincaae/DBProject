package com.example.demo.services;

import com.example.demo.controllers.dto.requests.CreateProductRequest;
import com.example.demo.controllers.dto.requests.UpdateProductRequest;
import com.example.demo.controllers.dto.responses.GetProductResponse;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("producto")
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public GetProductResponse get(Long id){ return from(id); }

    @Override
    public List<GetProductResponse> list(){
        List<GetProductResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public GetProductResponse create(CreateProductRequest request){
        Product product = from(request);
        return from(repository.save(product));
    }

    @Override
    public GetProductResponse update(Long id, UpdateProductRequest request){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("El producto no existe"));
        product = update(product, request);
        return from(product);
    }

    private Product update(Product product, UpdateProductRequest request){
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return repository.save(product);
    }

    private Product from(CreateProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }

    private GetProductResponse from(Product product){
        GetProductResponse response =  new GetProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }

    private GetProductResponse from(Long idProduct){
        return repository
                .findById(idProduct)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El producto no existe"));
    }
}
