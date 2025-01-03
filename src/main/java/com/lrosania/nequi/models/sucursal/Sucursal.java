package com.lrosania.nequi.models.sucursal;

import java.util.Set;

import com.lrosania.nequi.models.franquicia.Franquicia;
import com.lrosania.nequi.models.producto.Producto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sucursal")
@Data
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "sucursal_franquicias",
        joinColumns = @JoinColumn(name = "sucursal_id"),
        inverseJoinColumns = @JoinColumn(name = "franquicia_id")
    )
    private Set<Franquicia> franquicia;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private Set<Producto> producto;
}
