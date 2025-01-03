package com.lrosania.nequi.controllers.franquicia;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosania.nequi.Repositories.FranquiciaRepository;
import com.lrosania.nequi.Repositories.SucursalRepository;
import com.lrosania.nequi.models.franquicia.Franquicia;
import com.lrosania.nequi.models.franquicia.FranquiciaDto;
import com.lrosania.nequi.models.franquicia.FranquiciaMapper;
import com.lrosania.nequi.models.franquicia.FranquiciaSucursalDTO;
import com.lrosania.nequi.models.sucursal.Sucursal;

import jakarta.transaction.Transactional;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired 
    private SucursalRepository sucursalRepository;

    public FranquiciaDto create(FranquiciaDto franquiciaDto) {
        Franquicia franquicia = FranquiciaMapper.toEntity(franquiciaDto);
        franquicia = franquiciaRepository.save(franquicia);
        return FranquiciaMapper.toDTO(franquicia);
    }

    @Transactional
    public void addSucursal(Long idFranquicia, Long idSucursal){
        Franquicia franquicia = franquiciaRepository.findById(idFranquicia)
            .orElseThrow(()-> new RuntimeException("franquicia no encontrada"));
        
        Sucursal sucursal = sucursalRepository.findById(idSucursal)
            .orElseThrow(()-> new RuntimeException("sucursal no encontrada"));

        sucursal.getFranquicia().add(franquicia);
        sucursalRepository.save(sucursal);
    }

    public Optional<FranquiciaDto> getById(Long id) {
        return franquiciaRepository.findById(id)
                .map(FranquiciaMapper :: toDTO);
    }

    public List<FranquiciaDto> getAll() {
        List<Franquicia> franquicias = franquiciaRepository.findAll();
        return franquicias.stream()
                .map(FranquiciaMapper::toDTO)
                .toList();
    }

    public FranquiciaDto update(Long id, FranquiciaDto franquiciaDto) {
        Franquicia franquicia = franquiciaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("franquicia no encontrada"));
        
        franquicia.setNombre(franquiciaDto.getNombre());

        franquicia = franquiciaRepository.save(franquicia);
        return FranquiciaMapper.toDTO(franquicia);
    }

    public void delete(Long id) {
        Franquicia franquicia = franquiciaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("franquicia no encontrada"));
            franquiciaRepository.delete(franquicia);
    }
}
