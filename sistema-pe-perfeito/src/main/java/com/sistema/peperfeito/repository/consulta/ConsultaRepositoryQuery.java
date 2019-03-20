package com.sistema.peperfeito.repository.consulta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.peperfeito.model.Consulta;
import com.sistema.peperfeito.repository.filter.ConsultaFilter;
import com.sistema.peperfeito.repository.projection.ResumoConsulta;

public interface ConsultaRepositoryQuery {
	public Page<Consulta> filtrar(ConsultaFilter consultaFilter, Pageable pageable);
	public Page<ResumoConsulta> resumir(ConsultaFilter consultaFilter, Pageable pageable);

}
