package com.wsu.workorderproservice.service;

import org.springframework.stereotype.Service;

import com.wsu.workorderproservice.dto.ServiceOrderDTO;
import com.wsu.workorderproservice.model.ServiceOrder;
import com.wsu.workorderproservice.repository.ServiceOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {

       private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderDTO getServiceOrderById(Integer id) {
        ServiceOrder serviceOrder = serviceOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Order not found"));
        return mapToDto(serviceOrder);
    }

    public ServiceOrderDTO createServiceOrder(ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder serviceOrder = mapToEntity(serviceOrderDTO);
        return mapToDto(serviceOrderRepository.save(serviceOrder));
    }

    public ServiceOrderDTO updateServiceOrder(Integer id, ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder existingServiceOrder = serviceOrderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Service Order not found"));
        existingServiceOrder.setVin(serviceOrderDTO.getVin());
        // Update other fields as needed
        return mapToDto(serviceOrderRepository.save(existingServiceOrder));
    }

    public void deleteServiceOrder(Integer id) {
        if (!serviceOrderRepository.existsById(id)) {
            throw new RuntimeException("Service Order not found");
        }
        serviceOrderRepository.deleteById(id);
    }

    private ServiceOrder mapToEntity(ServiceOrderDTO serviceOrderDTO) {
        return ServiceOrder.builder()
                .id(serviceOrderDTO.getId())
                .vehicleId(serviceOrderDTO.getVin())
                .mechanicId(serviceOrderDTO.getMechanicId())
                .serviceId(serviceOrderDTO.getServiceId())
                .orderDate(serviceOrderDTO.getOrderDate())
                .status(serviceOrderDTO.getStatus())
                .build();
    }

    private ServiceOrderDTO mapToDto(ServiceOrder serviceOrder) {
        return ServiceOrderDTO.builder()
                .id(serviceOrder.getId())
                .vin(serviceOrder.getVin())
                .MID(serviceOrder.getMID())
                .serviceId(serviceOrder.getServiceId())
                .recievedDate(serviceOrder.getRecievedDate())
                .status(serviceOrder.getStatus())
                .build();
    }
}
