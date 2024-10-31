package com.wsu.workorderproservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsu.workorderproservice.dto.ServiceOrderDTO;
import com.wsu.workorderproservice.service.ServiceOrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serviceOrders")
public class ServiceOrderController {
    
    private final ServiceOrderService serviceOrderService;

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> getServiceOrder(@PathVariable Integer id) {
        return ResponseEntity.ok(serviceOrderService.getServiceOrderById(id));
    }
    @PostMapping
    public ResponseEntity<ServiceOrderDTO> createServiceOrder(@RequestBody @Valid ServiceOrderDTO serviceOrderDTO) {
        return new ResponseEntity<>(serviceOrderService.createServiceOrder(serviceOrderDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> updateServiceOrder(@PathVariable Integer id, @RequestBody @Valid ServiceOrderDTO serviceOrderDTO) {
        return ResponseEntity.ok(serviceOrderService.updateServiceOrder(id, serviceOrderDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceOrder(@PathVariable Integer id) {
        serviceOrderService.deleteServiceOrder(id);
        return ResponseEntity.noContent().build();
    }
}
