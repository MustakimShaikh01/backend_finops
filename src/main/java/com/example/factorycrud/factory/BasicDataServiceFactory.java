package com.example.factorycrud.factory;

import com.example.factorycrud.service.BasicDataService;
import com.example.factorycrud.service.impl.InMemoryBasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BasicDataServiceFactory {

    @Autowired
    private ApplicationContext ctx;

    /**
     * Factory method to choose service implementation.
     * Currently chooses in-memory. Change logic or add profile checks to switch to JPA.
     */
    public BasicDataService getService() {
        // Simple example: always return in-memory service.
        return ctx.getBean(InMemoryBasicDataService.class);
    }
}
