package com.sistema.peperfeito.repository.consulta;

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

import com.sistema.peperfeito.model.Consulta;
import com.sistema.peperfeito.model.Consulta_;
import com.sistema.peperfeito.model.Paciente_;
import com.sistema.peperfeito.repository.filter.ConsultaFilter;
import com.sistema.peperfeito.repository.projection.ResumoConsulta;

public class ConsultaRepositoryImpl implements ConsultaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Consulta> filtrar(ConsultaFilter consultaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Consulta> criteria = builder.createQuery(Consulta.class);
		Root<Consulta> root = criteria.from(Consulta.class);
		
		Predicate[] predicates = criarRestricoes(consultaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Consulta> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(consultaFilter));
	}
	
	@Override
	public Page<ResumoConsulta> resumir(ConsultaFilter consultaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoConsulta> criteria = builder.createQuery(ResumoConsulta.class);
		Root<Consulta> root = criteria.from(Consulta.class);
				
		criteria.select(builder.construct(ResumoConsulta.class
				, root.get(Consulta_.dataHora), root.get(Consulta_.paciente).get(Paciente_.nome)
				, root.get(Consulta_.situacao), root.get(Consulta_.valor), root.get(Consulta_.observacao)));
				
		Predicate[] predicates = criarRestricoes(consultaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoConsulta> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(consultaFilter));
		
	}
	
	private Predicate[] criarRestricoes(ConsultaFilter consultaFilter, CriteriaBuilder builder, Root<Consulta> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(consultaFilter.getDataHora())) {
			predicates.add(
					builder.equal(root.get(Consulta_.dataHora), consultaFilter.getDataHora()));
		}
		if (!StringUtils.isEmpty(consultaFilter.getPaciente())) {
			predicates.add(builder.like(
					builder.lower(root.get(Consulta_.paciente).get(Paciente_.nome)), "%" + consultaFilter.getPaciente().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(consultaFilter.getSituacao())) {
			predicates.add(builder.like(
					builder.lower(root.get(Consulta_.situacao.toString())), "%" + consultaFilter.getSituacao().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}	
	
	private void adicionarRestricoesPaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistroPagina;
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistroPagina);
	}
	
	private Long total(ConsultaFilter consultaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Consulta> root = criteria.from(Consulta.class);
		
		Predicate[] predicates = criarRestricoes(consultaFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}	
}
