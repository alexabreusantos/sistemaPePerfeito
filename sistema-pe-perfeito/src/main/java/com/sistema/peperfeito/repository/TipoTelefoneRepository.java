package com.sistema.peperfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.peperfeito.model.TipoTelefone;
import com.sistema.peperfeito.repository.tipotelefone.TipoTelefoneRepositoryQuery;

public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long>, TipoTelefoneRepositoryQuery {

}
