package com.sistema.peperfeito.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.peperfeito.model.TipoTelefone;
import com.sistema.peperfeito.repository.TipoTelefoneRepository;

@RestController
@RequestMapping("/tipos_telefones")
public class TipoTelefoneResource {
	
	@Autowired
	private TipoTelefoneRepository tipoTelefoneRepository;
	
	@GetMapping
	public List<TipoTelefone> listasr(){
		return tipoTelefoneRepository.findAll();
	}

}
