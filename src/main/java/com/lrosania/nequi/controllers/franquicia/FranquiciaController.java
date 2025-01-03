package com.lrosania.nequi.controllers.franquicia;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosania.nequi.models.franquicia.Franquicia;
import com.lrosania.nequi.models.franquicia.FranquiciaDto;
import com.lrosania.nequi.models.franquicia.FranquiciaSucursalDTO;
import com.lrosania.nequi.models.sucursal.Sucursal;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/franquicia")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

     @PostMapping
     public FranquiciaDto post(@RequestBody FranquiciaDto franquiciaDto) {
         return franquiciaService.create(franquiciaDto);
     }

     @PostMapping("/{idFranquicia}/{idSucursal}")
     public ResponseEntity<String> addFranquiciaToSucursal(@PathVariable Long idFranquicia, @PathVariable Long idSucursal) {
        franquiciaService.addSucursal(idFranquicia, idSucursal);
        return ResponseEntity.ok("Franquicia agregada a la sucursal.");
    }

     @GetMapping
    public List<FranquiciaDto> getAll() {
        return franquiciaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranquiciaDto> getById(@PathVariable Long id) {
        Optional<FranquiciaDto> franquicia = franquiciaService.getById(id);
        return franquicia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranquiciaDto> put(@PathVariable Long id, @RequestBody FranquiciaDto franquiciaDto) {      
        return ResponseEntity.ok(franquiciaService.update(id, franquiciaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FranquiciaDto> delete(@PathVariable Long id){
        franquiciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
     
}
