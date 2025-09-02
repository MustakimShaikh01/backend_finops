package com.example.factorycrud.service.impl;

import com.example.factorycrud.exception.NotFoundException;
import com.example.factorycrud.model.BasicData;
import com.example.factorycrud.service.BasicDataService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryBasicDataService implements BasicDataService {
    private final Map<String, BasicData> store = new ConcurrentHashMap<>();

    @Override
    public BasicData create(BasicData data) {
        if (data.getId() == null) {
            // id generated in model constructor
        }
        store.put(data.getId(), data);
        return data;
    }

    @Override
    public Optional<BasicData> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<BasicData> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public BasicData update(String id, BasicData data) {
        BasicData existing = store.get(id);
        if (existing == null) throw new NotFoundException("BasicData not found: " + id);
        existing.setName(data.getName());
        existing.setValue(data.getValue());
        store.put(id, existing);
        return existing;
    }

    @Override
    public void delete(String id) {
        if (store.remove(id) == null) throw new NotFoundException("BasicData not found: " + id);
    }
}
