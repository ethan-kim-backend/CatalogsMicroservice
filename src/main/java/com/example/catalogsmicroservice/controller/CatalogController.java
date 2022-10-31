package com.example.catalogsmicroservice.controller;

import com.example.catalogsmicroservice.jpa.CatalogEntity;
import com.example.catalogsmicroservice.jpa.CatalogRepository;
import com.example.catalogsmicroservice.service.CatalogService;
import com.example.catalogsmicroservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {
    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's Working in Catalog Service on PORT %s", env.getProperty("local.server.port"));
    }


    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getUsers(){
        Iterable<CatalogEntity> catalogList = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        catalogList.forEach(user->{
            result.add(modelMapper.map(user, ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
