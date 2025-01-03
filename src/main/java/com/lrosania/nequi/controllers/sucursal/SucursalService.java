package com.lrosania.nequi.controllers.sucursal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosania.nequi.Repositories.SucursalRepository;
import com.lrosania.nequi.models.franquicia.Franquicia;
import com.lrosania.nequi.models.franquicia.FranquiciaMapper;
import com.lrosania.nequi.models.sucursal.Sucursal;
import com.lrosania.nequi.models.sucursal.SucursalDto;
import com.lrosania.nequi.models.sucursal.SucursalMapper;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalDto create(SucursalDto sucursalDto) {
        Sucursal sucursal = SucursalMapper.toEntity(sucursalDto);
        sucursal = sucursalRepository.save(sucursal);
        return SucursalMapper.toDTO(sucursal);
    }

    public Optional<SucursalDto> getById(Long id) {
        return sucursalRepository.findById(id)
                .map(SucursalMapper::toDTO);
    }

    public List<SucursalDto> getAll() {
        List<Sucursal> sucursal = sucursalRepository.findAll();
        return sucursal.stream()
                .map(SucursalMapper::toDTO)
                .toList();
    }

    public SucursalDto update(Long id, SucursalDto sucursalDto) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        sucursal.setNombre(sucursalDto.getNombre());

        sucursal = sucursalRepository.save(sucursal);
        return SucursalMapper.toDTO(sucursal);
    }

    public void delete(Long id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));
        sucursalRepository.delete(sucursal);
    }
}
