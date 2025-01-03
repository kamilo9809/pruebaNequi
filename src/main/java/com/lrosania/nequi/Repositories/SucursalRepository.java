package com.lrosania.nequi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lrosania.nequi.models.sucursal.Sucursal;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
