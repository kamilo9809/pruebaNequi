package com.lrosania.nequi.controllers.producto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosania.nequi.models.producto.ProductoDto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ProductoDto post(@RequestBody ProductoDto productoDto) {
        return productoService.create(productoDto);
    }

         @GetMapping
    public List<ProductoDto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getById(@PathVariable Long id) {
        Optional<ProductoDto> producto = productoService.getById(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> put(@PathVariable Long id, @RequestBody ProductoDto productoDto) {      
        return ResponseEntity.ok(productoService.update(id, productoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDto> delete(@PathVariable Long id){
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
