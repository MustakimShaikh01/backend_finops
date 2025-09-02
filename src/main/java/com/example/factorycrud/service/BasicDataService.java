package com.example.factorycrud.service;

import com.example.factorycrud.model.BasicData;

import java.util.List;
import java.util.Optional;

public interface BasicDataService {
    BasicData create(BasicData data);
    Optional<BasicData> findById(String id);
    List<BasicData> findAll();
    BasicData update(String id, BasicData data);
    void delete(String id);
}
