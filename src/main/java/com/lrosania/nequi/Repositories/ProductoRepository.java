package com.lrosania.nequi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lrosania.nequi.models.producto.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
