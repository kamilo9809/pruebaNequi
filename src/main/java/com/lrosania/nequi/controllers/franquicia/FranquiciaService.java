package com.lrosania.nequi.controllers.franquicia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosania.nequi.Repositories.FranquiciaRepository;
import com.lrosania.nequi.models.franquicia.Franquicia;
import com.lrosania.nequi.models.franquicia.FranquiciaDto;
import com.lrosania.nequi.models.franquicia.FranquiciaMapper;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public FranquiciaDto create(FranquiciaDto franquiciaDto) {
        Franquicia franquicia = FranquiciaMapper.toEntity(franquiciaDto);
        franquicia = franquiciaRepository.save(franquicia);
        return FranquiciaMapper.toDTO(franquicia);
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
