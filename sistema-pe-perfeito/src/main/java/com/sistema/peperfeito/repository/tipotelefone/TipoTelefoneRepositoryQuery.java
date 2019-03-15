package com.sistema.peperfeito.repository.tipotelefone;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sistema.peperfeito.model.TipoTelefone;
import com.sistema.peperfeito.repository.filter.TipoTelefoneFilter;

public interface TipoTelefoneRepositoryQuery {
	
	public Page<TipoTelefone> filtrar(TipoTelefoneFilter tipoTelefoneFilter, Pageable pageable);
}
