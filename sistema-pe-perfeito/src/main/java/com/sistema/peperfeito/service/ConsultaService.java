package com.sistema.peperfeito.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.peperfeito.model.Consulta;
import com.sistema.peperfeito.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@PersistenceContext
	private EntityManager manager;
	
	private Consulta buscarConsultaPeloCodigo(Long codigo) {
		Consulta consultaSalva = consultaRepository.findOne(codigo);
		if (consultaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return consultaSalva;
	}
			
	public Consulta salvar(Consulta consulta) {	
		return consultaRepository.save(consulta);
	}
	
	public Consulta atualizar(Long codigo, Consulta consulta) {
		Consulta consultaSalva = buscarConsultaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(consulta, consultaSalva, "codigo");
		return consultaRepository.save(consultaSalva);
	}
}
