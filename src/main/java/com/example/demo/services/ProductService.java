package com.example.demo.services;

import com.example.demo.controllers.dto.requests.ProductRequest;
import com.example.demo.controllers.dto.responses.BaseResponse;
import com.example.demo.controllers.dto.responses.ProductResponse;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ICategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("product")
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ICategoryRepository catRep;

    @Override
    public BaseResponse get(Long id) {
        Product product = findAndEnsureExist(id);

        return BaseResponse.builder()
                .data(product)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse list(String keyword) {
        List<Product> products;

        if(keyword == null) {
            products = repository
                    .findAll()
                    .stream()
                    .collect(Collectors.toList());
        } else {
            products = repository.findAllByNameContainingIgnoreCase(keyword)
                    .stream()
                    .collect(Collectors.toList());
        }

        return BaseResponse.builder()
                .data(products)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    @Override
    public BaseResponse delete(Long id) {
        repository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public BaseResponse create(ProductRequest request) {
        Product product = repository.save(from(request));

        return BaseResponse.builder()
                .data(product)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public BaseResponse update(Long id, ProductRequest request) {
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("El producto no existe"));
        product = update(product, request);

        return BaseResponse.builder()
                .data(product)
                .message("Successful operation")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK).build();
    }

    private Product update(Product product, ProductRequest request) {
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        return repository.save(product);
    }

    private Product from(ProductRequest request) {
        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        Optional<Category> category = catRep.findById(request.getCategoryId());
        category.ifPresent(product::setCategory);

        return product;
    }

    private ProductResponse from(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCategoryId(product.getCategory().getId());
        return response;
    }

    private Product findAndEnsureExist(Long idProduct) {
        return repository
                .findById(idProduct)
                .orElseThrow(() -> new RuntimeException("El producto no existe"));
    }
}
