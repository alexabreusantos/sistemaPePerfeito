package com.sistema.peperfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.peperfeito.model.Podologo;
import com.sistema.peperfeito.repository.podologo.PodologoRepositoryQuery;

public interface PodologoRepository extends JpaRepository<Podologo, Long>, PodologoRepositoryQuery{

}
