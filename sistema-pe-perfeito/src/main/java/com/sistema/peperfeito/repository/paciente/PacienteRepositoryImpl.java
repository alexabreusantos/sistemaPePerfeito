package com.sistema.peperfeito.repository.paciente;

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

import com.sistema.peperfeito.model.Paciente;
import com.sistema.peperfeito.model.Paciente_;
import com.sistema.peperfeito.repository.filter.PacienteFilter;
import com.sistema.peperfeito.repository.projection.ResumoPaciente;

public class PacienteRepositoryImpl implements PacienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Paciente> filtrar(PacienteFilter pacienteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Paciente> criteria = builder.createQuery(Paciente.class);
		Root<Paciente> root = criteria.from(Paciente.class);
		
		Predicate[] predicates = criarRestricoes(pacienteFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Paciente> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(pacienteFilter));
	}
		
	private Predicate[] criarRestricoes(PacienteFilter pacienteFilter, CriteriaBuilder builder,
			Root<Paciente> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(pacienteFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Paciente_.nome)), "%" + pacienteFilter.getNome().toLowerCase() + "%"));
		}
		if (!StringUtils.isEmpty(pacienteFilter.getEmail())) {
			predicates.add(builder.like(
					builder.lower(root.get(Paciente_.email)), "%" + pacienteFilter.getEmail().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(pacienteFilter.getDataNascimento())) {
			predicates.add(
					builder.equal(root.get(Paciente_.dataNascimento), pacienteFilter.getDataNascimento()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	@Override
	public Page<ResumoPaciente> resumir(PacienteFilter pacienteFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoPaciente> criteria = builder.createQuery(ResumoPaciente.class);
		Root<Paciente> root = criteria.from(Paciente.class);
				
		criteria.select(builder.construct(ResumoPaciente.class
				, root.get(Paciente_.codigo), root.get(Paciente_.nome)
				, root.get(Paciente_.dataNascimento), root.get(Paciente_.email)));
				
		Predicate[] predicates = criarRestricoes(pacienteFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoPaciente> query = manager.createQuery(criteria);
		adicionarRestricoesPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(pacienteFilter));
	}

	
	private void adicionarRestricoesPaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistroPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistroPagina;
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistroPagina);
	}
	
	private Long total(PacienteFilter pacienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Paciente> root = criteria.from(Paciente.class);
		
		Predicate[] predicates = criarRestricoes(pacienteFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}
}
