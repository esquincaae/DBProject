package com.example.demo.services;


import com.example.demo.controllers.dto.requests.CreateCarRequest;
import com.example.demo.controllers.dto.requests.UpdateCarRequest;
import com.example.demo.controllers.dto.responses.GetCarResponse;
import com.example.demo.entities.Car;
import com.example.demo.entities.Product;
import com.example.demo.entities.Rol;
import com.example.demo.entities.User;
import com.example.demo.repositories.ICarRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("carrito")
public class CarService implements ICarService {

    @Autowired
    private ICarRepository repository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public GetCarResponse get(Long id){ return from(id); }

    @Override
    public List<GetCarResponse> list(){
        List<GetCarResponse> responses = new ArrayList<>();
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id){repository.deleteById(id);}

    @Override
    public GetCarResponse create(CreateCarRequest request){
        Car car = new Car();//from(request);

        car.setPrecioTotal(request.getPrecioTotal().doubleValue());
        //car.setUser_id(request.getUserId().longValue());
        //Optional<Product> product = ProductRepository;
                ;
        return from(repository.save(car));
    }

    @Override
    public GetCarResponse update(Long id, UpdateCarRequest request){
        Car car = repository.findById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));
        car = update(car, request);
        return from(car);
    }

    private Car update(Car car, UpdateCarRequest request){
        car.setPrecioTotal(request.getPrecioTotal());
        return repository.save(car);
    }

    private Car from(CreateCarRequest request){
        Car car = new Car();
        car.setPrecioTotal(request.getPrecioTotal());
        return car;
    }

    private GetCarResponse from(Car car){
        GetCarResponse response =  new GetCarResponse();
        response.setId(car.getId());
        response.setPrecioTotal(car.getPrecioTotal());
        return response;
    }

    private GetCarResponse from(Long idCar){
        return repository
                .findById(idCar)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
}
