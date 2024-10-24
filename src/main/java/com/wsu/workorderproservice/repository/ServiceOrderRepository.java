package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.ServiceOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer>{
// Built-in JPA methods: save, findByID, findAll, deleteById

    //@Query("SELECT s FROM ServiceOrder s WHERE s.vin = :vin")
    //List<ServiceOrder> findByVehicleId(@Param("vin") Integer vin)
} 
