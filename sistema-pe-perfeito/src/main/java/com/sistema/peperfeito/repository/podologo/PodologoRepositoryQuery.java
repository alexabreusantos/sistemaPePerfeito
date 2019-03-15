package com.sistema.peperfeito.repository.podologo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.peperfeito.model.Podologo;
import com.sistema.peperfeito.repository.filter.PodologoFilter;

public interface PodologoRepositoryQuery {
	public Page<Podologo> filtrar(PodologoFilter podologoFilter, Pageable pageable);
}
