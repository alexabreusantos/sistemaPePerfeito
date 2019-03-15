package com.sistema.peperfeito.repository.tipotelefone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.sistema.peperfeito.model.TipoTelefone;
import com.sistema.peperfeito.model.TipoTelefone_;
import com.sistema.peperfeito.repository.filter.TipoTelefoneFilter;

public class TipoTelefoneRepositoryImpl implements TipoTelefoneRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<TipoTelefone> filtrar(TipoTelefoneFilter tipoTelefoneFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TipoTelefone> criteria = builder.createQuery(TipoTelefone.class);
		Root<TipoTelefone> root = criteria.from(TipoTelefone.class);
		
		Predicate[] predicates = criarRestricoes(tipoTelefoneFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<TipoTelefone> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(tipoTelefoneFilter));
	}
		
	private Predicate[] criarRestricoes(TipoTelefoneFilter tipoTelefoneFilter, CriteriaBuilder builder,
			Root<TipoTelefone> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(tipoTelefoneFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(TipoTelefone_.nome)), "%" + tipoTelefoneFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesPaginacao(TypedQuery<TipoTelefone> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistroPagina;
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistroPagina);
	}
	
	private Long total(TipoTelefoneFilter tipoTelefoneFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<TipoTelefone> root = criteria.from(TipoTelefone.class);
		
		Predicate[] predicates = criarRestricoes(tipoTelefoneFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}

}
