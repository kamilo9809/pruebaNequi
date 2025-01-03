package com.lrosania.nequi.models.producto;

import java.util.stream.Collectors;

import com.lrosania.nequi.models.sucursal.SucursalMapper;


public class ProductoMapper {

     public static ProductoDto toDTO(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setNombre(producto.getNombre());
        dto.setStock(producto.getStock());

        // dto.setSucursal(producto.getSucursal().stream()
        //     .map(SucursalMapper::toDTO)
        //     .collect(Collectors.toSet()));

        return dto;
    }

    public static Producto toEntity(ProductoDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setStock(dto.getStock());

        // producto.setSucursal(dto.getSucursal().stream()
        //     .map(SucursalMapper::toEntity)
        //     .collect(Collectors.toSet()));

        return producto;
    }
}
