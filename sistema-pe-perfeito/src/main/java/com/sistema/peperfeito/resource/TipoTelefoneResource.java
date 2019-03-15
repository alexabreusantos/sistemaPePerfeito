package com.sistema.peperfeito.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.peperfeito.event.RecursoCriadoEvent;
import com.sistema.peperfeito.model.TipoTelefone;
import com.sistema.peperfeito.repository.TipoTelefoneRepository;
import com.sistema.peperfeito.repository.filter.TipoTelefoneFilter;
import com.sistema.peperfeito.service.TipoTelefoneService;


@RestController
@RequestMapping("/tipos_telefones")
public class TipoTelefoneResource {
	
	@Autowired
	private TipoTelefoneRepository tipoTelefoneRepository;
	
	@Autowired
	private TipoTelefoneService tipoTelefoneService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<TipoTelefone> pesquisar(TipoTelefoneFilter telefoneFilter, Pageable pageable){
		return tipoTelefoneRepository.filtrar(telefoneFilter, pageable);
	}
	
	@PostMapping
	public ResponseEntity<TipoTelefone> criar(@Valid @RequestBody TipoTelefone tipoTelefone, HttpServletResponse response) {
		TipoTelefone tipoTelefoneSalvo = tipoTelefoneRepository.save(tipoTelefone);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoTelefoneSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoTelefoneSalvo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<TipoTelefone> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoTelefone tipoTelefone = tipoTelefoneRepository.findOne(codigo);
		return tipoTelefone != null ? ResponseEntity.ok(tipoTelefone) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<TipoTelefone> atualizar(@PathVariable Long codigo, @Valid @RequestBody TipoTelefone tipoTelefone) {
		TipoTelefone tipoTelefoneSalvo = tipoTelefoneService.atualizar(codigo, tipoTelefone);
		return ResponseEntity.ok(tipoTelefoneSalvo);
	}	

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		tipoTelefoneRepository.delete(codigo);
	}

}
