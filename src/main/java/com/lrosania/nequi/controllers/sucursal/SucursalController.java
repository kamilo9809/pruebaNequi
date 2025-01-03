package com.lrosania.nequi.controllers.sucursal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosania.nequi.models.sucursal.SucursalDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping
    public SucursalDto post(@RequestBody SucursalDto sucursalDto) {
        return sucursalService.create(sucursalDto);
    }
    
    @GetMapping
    public List<SucursalDto> getAll() {
        return sucursalService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDto> getById(@PathVariable Long id) {
        Optional<SucursalDto> sucursal = sucursalService.getById(id);
        return sucursal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDto> put(@PathVariable Long id, @RequestBody SucursalDto sucursalDto) {      
        return ResponseEntity.ok(sucursalService.update(id, sucursalDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SucursalDto> delete(@PathVariable Long id){
        sucursalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
