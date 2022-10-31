package com.example.catalogsmicroservice.service;

import com.example.catalogsmicroservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
