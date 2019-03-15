package com.sistema.peperfeito.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.peperfeito.model.TipoTelefone;
import com.sistema.peperfeito.repository.TipoTelefoneRepository;

@Service
public class TipoTelefoneService {
	
	@Autowired
	private TipoTelefoneRepository tipoTelefoneRepository;
	
	public TipoTelefone buscarPeloCodigo(Long codigo) {					
		TipoTelefone tipoTelefoneSalva = tipoTelefoneRepository.findOne(codigo);
		if (tipoTelefoneSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tipoTelefoneSalva;
	}
	
	public TipoTelefone atualizar(Long codigo, TipoTelefone tipoTelefone) {
		TipoTelefone tipoTelefoneSalvo = buscarPeloCodigo(codigo);
		
		BeanUtils.copyProperties(tipoTelefone, tipoTelefoneSalvo, "codigo");
		return tipoTelefoneRepository.save(tipoTelefoneSalvo);
	}
}
