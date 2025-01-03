package com.lrosania.nequi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lrosania.nequi.models.franquicia.Franquicia;



@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long>{

}
