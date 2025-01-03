package com.lrosania.nequi.models.sucursal;

import java.util.stream.Collectors;

import com.lrosania.nequi.models.franquicia.FranquiciaMapper;
import com.lrosania.nequi.models.producto.ProductoMapper;



public class SucursalMapper {

    public static SucursalDto toDTO(Sucursal sucursal) {
        SucursalDto dto = new SucursalDto();
        dto.setNombre(sucursal.getNombre());

        // dto.setFranquicia(sucursal.getFranquicia().stream()
        //         .map(FranquiciaMapper::toDTO)
        //         .collect(Collectors.toSet()));

        // dto.setProducto(sucursal.getProducto().stream()
        //         .map(ProductoMapper::toDTO)
        //         .collect(Collectors.toSet()));

        return dto;
    }

    public static Sucursal toEntity(SucursalDto dto) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(dto.getNombre());

        // sucursal.setFranquicia(dto.getFranquicia().stream()
        //         .map(FranquiciaMapper::toEntity)
        //         .collect(Collectors.toSet()));

        // sucursal.setProducto(dto.getProducto().stream()
        //         .map(ProductoMapper::toEntity)
        //         .collect(Collectors.toSet()));

        return sucursal;
    }
}
