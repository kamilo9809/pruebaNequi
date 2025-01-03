package com.lrosania.nequi.models.producto;

import java.util.Set;

import com.lrosania.nequi.models.sucursal.Sucursal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private int stock;

    @ManyToMany
    @JoinTable(
        name ="producto_sucursal", 
        joinColumns =  @JoinColumn(name = "producto_id"),
        inverseJoinColumns = @JoinColumn(name = "sucursal_id")
        )
    private Set<Sucursal> sucursal;



}
