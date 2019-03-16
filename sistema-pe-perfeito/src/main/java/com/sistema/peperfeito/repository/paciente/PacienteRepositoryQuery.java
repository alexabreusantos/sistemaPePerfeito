package com.sistema.peperfeito.repository.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.peperfeito.model.Paciente;
import com.sistema.peperfeito.repository.filter.PacienteFilter;
import com.sistema.peperfeito.repository.projection.ResumoPaciente;

public interface PacienteRepositoryQuery {
	public Page<Paciente> filtrar(PacienteFilter pacienteFilter, Pageable pageable);
	public Page<ResumoPaciente> resumir(PacienteFilter pacienteFilter, Pageable pageable);
}
