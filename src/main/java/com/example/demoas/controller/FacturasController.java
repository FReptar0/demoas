package com.example.demoas.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import com.example.demoas.model.Facturas;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demoas.repository.FacturaRepository;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturasController {
    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping()
    public ResponseEntity<List<Facturas>> listar() {
        List<Facturas> facturas = facturaRepository.findAll();
        return new ResponseEntity<List<Facturas>>(facturas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Facturas> registrar(@RequestBody Facturas factura) {
        Facturas facturaNew = facturaRepository.save(factura);
        return new ResponseEntity<Facturas>(facturaNew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Facturas> actualizar(@RequestBody Facturas factura) {
        Facturas facturaUpdate = facturaRepository.save(factura);
        return new ResponseEntity<Facturas>(facturaUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Long id) {
        facturaRepository.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
