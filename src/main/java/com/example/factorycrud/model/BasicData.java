package com.example.factorycrud.model;

import java.time.Instant;
import java.util.UUID;

public class BasicData {
    private String id;
    private String name;
    private String value;
    private Instant createdAt;

    public BasicData() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = Instant.now();
    }

    public BasicData(String name, String value) {
        this();
        this.name = name;
        this.value = value;
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
