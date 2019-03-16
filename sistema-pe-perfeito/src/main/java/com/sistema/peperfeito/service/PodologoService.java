package com.sistema.peperfeito.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.peperfeito.model.Podologo;
import com.sistema.peperfeito.repository.PodologoRepository;

@Service
public class PodologoService {
	
	@Autowired
	private PodologoRepository podologoRepository;

	public Podologo atualizar(Long codigo, Podologo podologo) {
		Podologo podologoSalvo = buscarPodologoPeloCodigo(codigo);
		
		podologoSalvo.getTelefones().clear();
		podologoSalvo.getTelefones().addAll(podologo.getTelefones());
		podologoSalvo.getTelefones().forEach(c -> c.setPodologo(podologoSalvo));
		
		BeanUtils.copyProperties(podologo, podologoSalvo, "codigo", "telefones");
		return podologoRepository.save(podologoSalvo);
	}
	
	private Podologo buscarPodologoPeloCodigo(Long codigo) {
		Podologo podologoSalvo = podologoRepository.findOne(codigo);
		if (podologoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return podologoSalvo;
	}

	public Podologo salvar(Podologo podologo) {
		podologo.getTelefones().forEach(c -> c.setPodologo(podologo));
		return podologoRepository.save(podologo);
	}
	
}
