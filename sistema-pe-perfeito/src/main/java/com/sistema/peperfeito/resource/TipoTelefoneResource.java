package com.sistema.peperfeito.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<TipoTelefone> criar(@Valid @RequestBody TipoTelefone tipoTelefone, HttpServletResponse response) {
		TipoTelefone tipoTelefoneSalvo = tipoTelefoneRepository.save(tipoTelefone);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(tipoTelefoneSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(tipoTelefoneSalvo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<TipoTelefone> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoTelefone tipoTelefone = tipoTelefoneRepository.findOne(codigo);
		return tipoTelefone != null ? ResponseEntity.ok(tipoTelefone) : ResponseEntity.notFound().build();
	}

}
