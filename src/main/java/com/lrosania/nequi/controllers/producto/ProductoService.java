package com.lrosania.nequi.controllers.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosania.nequi.Repositories.ProductoRepository;
import com.lrosania.nequi.models.franquicia.Franquicia;
import com.lrosania.nequi.models.franquicia.FranquiciaDto;
import com.lrosania.nequi.models.franquicia.FranquiciaMapper;
import com.lrosania.nequi.models.producto.Producto;
import com.lrosania.nequi.models.producto.ProductoDto;
import com.lrosania.nequi.models.producto.ProductoMapper;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoDto create(ProductoDto productoDto) {
        Producto producto = ProductoMapper.toEntity(productoDto);
        producto = productoRepository.save(producto);
        return ProductoMapper.toDTO(producto);
    }

    public Optional<ProductoDto> getById(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toDTO);
    }

    public List<ProductoDto> getAll() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(ProductoMapper::toDTO)
                .toList();
    }

    public ProductoDto update(Long id, ProductoDto productoDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("producto no encontrada"));

        producto.setNombre(productoDto.getNombre());
        producto.setStock(productoDto.getStock());

        producto = productoRepository.save(producto);
        return ProductoMapper.toDTO(producto);
    }

    public void delete(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("producto no encontrada"));
        productoRepository.delete(producto);
    }

}
