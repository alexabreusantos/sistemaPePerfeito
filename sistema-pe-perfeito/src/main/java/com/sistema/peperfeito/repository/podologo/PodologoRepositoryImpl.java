package com.sistema.peperfeito.repository.podologo;

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

import com.sistema.peperfeito.model.Podologo;
import com.sistema.peperfeito.model.Podologo_;
import com.sistema.peperfeito.repository.filter.PodologoFilter;
import com.sistema.peperfeito.repository.projection.ResumoPodologo;

public class PodologoRepositoryImpl implements PodologoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Podologo> filtrar(PodologoFilter podologoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Podologo> criteria = builder.createQuery(Podologo.class);
		Root<Podologo> root = criteria.from(Podologo.class);
		
		Predicate[] predicates = criarRestricoes(podologoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Podologo> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(podologoFilter));
	}
		
	private Predicate[] criarRestricoes(PodologoFilter podologoFilter, CriteriaBuilder builder,
			Root<Podologo> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(podologoFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Podologo_.nome)), "%" + podologoFilter.getNome().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(podologoFilter.getEmail())) {
			predicates.add(builder.like(
					builder.lower(root.get(Podologo_.email)), "%" + podologoFilter.getEmail().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(podologoFilter.getDataNascimento())) {
			predicates.add(
					builder.equal(root.get(Podologo_.dataNascimento), podologoFilter.getDataNascimento()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	@Override
	public Page<ResumoPodologo> resumir(PodologoFilter podologoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoPodologo> criteria = builder.createQuery(ResumoPodologo.class);
		Root<Podologo> root = criteria.from(Podologo.class);
				
		criteria.select(builder.construct(ResumoPodologo.class
				, root.get(Podologo_.codigo), root.get(Podologo_.nome)
				, root.get(Podologo_.dataNascimento), root.get(Podologo_.email)));
				
		Predicate[] predicates = criarRestricoes(podologoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoPodologo> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(podologoFilter));
	}

	
	private void adicionarRestricoesPaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistroPagina;
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistroPagina);
	}
	
	private Long total(PodologoFilter podologoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Podologo> root = criteria.from(Podologo.class);
		
		Predicate[] predicates = criarRestricoes(podologoFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}
}
