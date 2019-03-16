package com.sistema.peperfeito.repository.podologo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.peperfeito.model.Podologo;
import com.sistema.peperfeito.repository.filter.PodologoFilter;
import com.sistema.peperfeito.repository.projection.ResumoPodologo;

public interface PodologoRepositoryQuery {
	public Page<Podologo> filtrar(PodologoFilter podologoFilter, Pageable pageable);
	public Page<ResumoPodologo> resumir(PodologoFilter podologoFilter, Pageable pageable);
}
