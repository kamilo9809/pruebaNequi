package com.lrosania.nequi.models.producto;

import java.util.Set;

import com.lrosania.nequi.models.sucursal.SucursalDto;

import lombok.Data;

@Data
public class ProductoDto {
    private String nombre;

    private int stock;

    // private Set<SucursalDto> sucursal;
}
