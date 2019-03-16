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
import com.sistema.peperfeito.model.Podologo;
import com.sistema.peperfeito.repository.PodologoRepository;
import com.sistema.peperfeito.repository.filter.PodologoFilter;
import com.sistema.peperfeito.repository.projection.ResumoPodologo;
import com.sistema.peperfeito.service.PodologoService;

@RestController
@RequestMapping("/podologos")
public class PodologoResource {

	@Autowired
	private PodologoRepository podologoRepository;
	
	@Autowired
	private PodologoService podologoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

//	@GetMapping
//	public Page<Podologo> pesquisar(PodologoFilter podologoFilter, Pageable pageable){
//		return podologoRepository.filtrar(podologoFilter, pageable);
//	}
	
	@GetMapping
	public Page<ResumoPodologo> resumir(PodologoFilter podologoFilter, Pageable pageable){
		return podologoRepository.resumir(podologoFilter, pageable);
	}
		
	@PostMapping
	public ResponseEntity<Podologo> criar(@Valid @RequestBody Podologo podologo, HttpServletResponse response) {
		Podologo podologoSalvo = podologoService.salvar(podologo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, podologoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(podologoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Podologo> buscarPeloCodigo(@PathVariable Long codigo) {
		Podologo podologo = podologoRepository.findOne(codigo);
		return podologo != null ? ResponseEntity.ok(podologo) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		podologoRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Podologo> atualizar(@PathVariable Long codigo, @Valid @RequestBody Podologo podologo) {
		Podologo podologoSalvo = podologoService.atualizar(codigo, podologo);
		return ResponseEntity.ok(podologoSalvo);
	}
}
