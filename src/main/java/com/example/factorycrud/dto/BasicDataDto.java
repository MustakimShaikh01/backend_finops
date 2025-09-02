package com.example.factorycrud.dto;

import jakarta.validation.constraints.NotBlank;

public class BasicDataDto {
    private String id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "value is required")
    private String value;

    public BasicDataDto() {}

    public BasicDataDto(String id, String name, String value) {
        this.id = id; this.name = name; this.value = value;
    }

    // getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
