package com.lrosania.nequi.models.franquicia;

import java.util.stream.Collectors;

import com.lrosania.nequi.models.sucursal.SucursalMapper;


public class FranquiciaMapper {

    public static FranquiciaDto toDTO(Franquicia franquicia){
        FranquiciaDto dto = new FranquiciaDto();
        dto.setNombre(franquicia.getNombre());
        
        // dto.setSucursales(franquicia.getSucursales().stream()
        //     .map(SucursalMapper::toDTO)
        //     .collect(Collectors.toSet()));

            return dto;
    }

    public static Franquicia toEntity(FranquiciaDto dto){
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(dto.getNombre());

        // franquicia.setSucursales((dto.getSucursales().stream()
        //     .map(SucursalMapper::toEntity)
        //     .collect(Collectors.toSet())));
            return franquicia;
    }
}
