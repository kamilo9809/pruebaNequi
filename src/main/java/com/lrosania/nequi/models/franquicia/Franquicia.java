package com.lrosania.nequi.models.franquicia;

import java.util.Set;

import com.lrosania.nequi.models.sucursal.Sucursal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "franquicia")
@Data
public class Franquicia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @OneToMany(mappedBy = "franquicia",cascade = CascadeType.ALL)
    private Set<Sucursal> sucursales;
}
