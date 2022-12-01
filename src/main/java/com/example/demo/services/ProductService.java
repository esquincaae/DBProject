package com.example.demo.services;

import com.example.demo.controllers.dto.requests.ProductRequest;
import com.example.demo.controllers.dto.responses.ProductResponse;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ICategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
    public ProductResponse get(Long id){ return from(id); }

    @Override
    public List<ProductResponse> list(){
        List<ProductResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public ProductResponse create(ProductRequest request){
        Product product = from(request);
        return from(repository.save(product));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request){
        Product product = repository.findById(id).orElseThrow(() -> new RuntimeException("El producto no existe"));
        product = update(product, request);
        return from(product);
    }

    private Product update(Product product, ProductRequest request){
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return repository.save(product);
    }

    private Product from(ProductRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        Optional<Category> category = catRep.findById(request.getCategoryId());
        category.ifPresent(product::setCategory);

        return product;
    }

    private ProductResponse from(Product product){
        ProductResponse response =  new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCategoryId(product.getCategory().getId());
        return response;
    }

    private ProductResponse from(Long idProduct){
        return repository
                .findById(idProduct)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El producto no existe"));
    }
}
