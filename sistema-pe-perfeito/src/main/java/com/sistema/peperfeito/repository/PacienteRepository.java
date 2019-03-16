package com.sistema.peperfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.peperfeito.model.Paciente;
import com.sistema.peperfeito.repository.paciente.PacienteRepositoryQuery;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteRepositoryQuery{

}
