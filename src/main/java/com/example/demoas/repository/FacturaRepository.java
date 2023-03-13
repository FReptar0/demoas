package com.example.demoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demoas.model.*;


public interface FacturaRepository extends JpaRepository<Facturas, Long>{
    
}
