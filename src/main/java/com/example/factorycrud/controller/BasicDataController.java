package com.example.factorycrud.controller;

import com.example.factorycrud.dto.BasicDataDto;
import com.example.factorycrud.factory.BasicDataServiceFactory;
import com.example.factorycrud.model.BasicData;
import com.example.factorycrud.service.BasicDataService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/basic-data")
public class BasicDataController {

    private final BasicDataService service;

    public BasicDataController(BasicDataServiceFactory factory) {
        this.service = factory.getService();
    }

    @PostMapping
    public ResponseEntity<BasicDataDto> create(@Valid @RequestBody BasicDataDto dto) {
        BasicData model = new BasicData(dto.getName(), dto.getValue());
        BasicData created = service.create(model);
        BasicDataDto out = new BasicDataDto(created.getId(), created.getName(), created.getValue());
        return ResponseEntity.created(URI.create("/api/v1/basic-data/" + created.getId())).body(out);
    }

    @GetMapping
    public List<BasicDataDto> list() {
        return service.findAll().stream()
                .map(b -> new BasicDataDto(b.getId(), b.getName(), b.getValue()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasicDataDto> get(@PathVariable String id) {
        return service.findById(id)
                .map(b -> ResponseEntity.ok(new BasicDataDto(b.getId(), b.getName(), b.getValue())))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasicDataDto> update(@PathVariable String id, @Valid @RequestBody BasicDataDto dto) {
        BasicData data = new BasicData(dto.getName(), dto.getValue());
        BasicData updated = service.update(id, data);
        return ResponseEntity.ok(new BasicDataDto(updated.getId(), updated.getName(), updated.getValue()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
