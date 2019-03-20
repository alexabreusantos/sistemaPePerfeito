package com.sistema.peperfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.peperfeito.model.Consulta;
import com.sistema.peperfeito.repository.consulta.ConsultaRepositoryQuery;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>, ConsultaRepositoryQuery {
	
}
